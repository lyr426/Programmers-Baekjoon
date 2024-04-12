package 메이즈러너;

import java.io.*;
import java.util.*;

class Position{
	int x;
	int y; 
	
	Position(int x, int y){
		this.x = x; 
		this.y = y; 
	}
}

public class Main {
	
	static int N; 
	static int exitX; 
	static int exitY; 
	static int clear = 0; 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
		N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken()); 
		int K = Integer.parseInt(st.nextToken()); 
		int[][] maze = new int[N][N];
		Position[] competitor = new Position[M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " "); 
			for(int j=0; j<N; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken()); 
			}
			
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," "); 
			int x = Integer.parseInt(st.nextToken())-1; 
			int y = Integer.parseInt(st.nextToken())-1; 
			competitor[i] = new Position(x, y); 
		}
		st = new StringTokenizer(br.readLine(), " ");
		exitX = Integer.parseInt(st.nextToken())-1;
		exitY = Integer.parseInt(st.nextToken())-1;
		
		int moveCnt = 0; 
		for(int i=0; i<K; i++) {
			moveCnt += moveCompetitor(competitor, maze);
			maze = rotateMaze(competitor, maze); 
			if(clear >= M) {
				break; 
			}
		}
		bw.write(String.valueOf(moveCnt + "\n" + ++exitX + " " + ++exitY));
		bw.flush();

	}
	
	private static void print(Position[] competitor, int[][] maze) {
		System.out.println("미로판 ");
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println("사람위치");
		for(Position pos : competitor) {
			System.out.println(pos.x + " . " + pos.y);
		}
		System.out.println("출구 위치 ");
		System.out.println(exitX+ " . " + exitY);
		System.out.println();
	}

	private static int[][] rotateMaze(Position[] competitor, int[][] maze) {
		int size = 2; 
		
		boolean[][] area = new boolean[N][N]; 
		for(Position position : competitor) {
			if(position.x == -1) { 
				continue; 
			}
			area[position.x][position.y] = true; 
		}
		
		while(size <= N) {
			int startX = exitX - size+1; 
			int startY = exitY - size+1; 
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					int xn = startX + i; 
					int yn = startY + j; 
					if(checkRectangle(xn, yn, size, area)) {
						return roatate(xn, yn, size, maze, competitor); 
					}
					
				}
			}
			size += 1; 
		}
		
		return maze; 
	}

	private static int[][] roatate(int xn, int yn, int size, int[][] maze, Position[] competitor) {
		
		int[][] newMaze = new int[N][N]; 
		for(int i=0; i<N;i++) {
			newMaze[i] = maze[i].clone();
		}

		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++){
				if(maze[xn + i][yn + j] > 0) {
					maze[xn + i][yn + j] -= 1; 
				}
				newMaze[xn+j][yn+size-i-1] = maze[xn + i][yn + j]; 
			}
		}
		int tmpX = exitX; 
		exitX = xn + (exitY - yn) ; 
		exitY = (yn + size -1) - (tmpX - xn); 
		
		for(Position position : competitor) {
			if(position.x >= xn && position.x < xn + size && position.y >= yn && position.y < yn + size) {
				tmpX = position.x; 
				position.x = xn + (position.y - yn); 
				position.y = (yn + size - 1) - (tmpX - xn); 
			}
		}
		
		return newMaze; 
	}

	private static boolean checkRectangle(int x, int y, int size, boolean[][] area) {
		
		boolean flag = false; 
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				int xn = x + i; 
				int yn = y + j; 
				if(xn < 0 || xn >= N || yn < 0 || yn >= N) {
					return false;
				}
				if(area[xn][yn]) {
					flag = true; 
				}
			}
		}
		
		return flag; 
	}

	private static int moveCompetitor(Position[] competitor, int[][] maze) {
		int[] dx = {-1, 1, 0, 0}; 
		int[] dy = {0, 0, -1, 1}; 
		int moveCnt = 0; 
		
		for(Position position: competitor) {
			if(position.x == -1 && position.y == -1) continue; 
			int dist = Math.abs(position.x - exitX) + Math.abs(position.y - exitY); 
			
			for(int i=0; i<4; i++) {
				int xn = position.x + dx[i];
				int yn = position.y + dy[i]; 
				
				if(xn < 0 || xn >= N || yn < 0 || yn >= N || maze[xn][yn] > 0) {
					continue; 
				}
				if(xn == exitX && yn == exitY) {
					position.x = -1; 
					position.y = -1; 
					moveCnt += 1; 
					clear += 1; 
					break; 
				}
				int dist2 = Math.abs(xn - exitX) + Math.abs(yn - exitY); 
				if(dist2 < dist) {
					position.x = xn;
					position.y = yn; 
					moveCnt += 1; 
					break; 
				}
			}
			
		}
		
		return moveCnt; 
		
	}

}
