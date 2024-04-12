package 꼬리잡기놀이;

import java.util.*; 
import java.io.*;

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
	static int M;	
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0}; 
	static Position[] head;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] board = new int[N][N]; 
		head = new Position[M];
		int idx = 0; 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " "); 
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) {
					head[idx++] = new Position(i, j); 
				}
			}
		}
		int res = 0;
		
		for(int i=0; i<K; i++) {
			moveTeam(board);
//			System.out.println("무브 ~ ");
//			print(board); 
			int dir = (i/N)%4; 
			int startX = 0; 
			int startY = 0; 
			switch(dir) {
			case 0: 
				startX = i%N; 
				break;
			case 1: 
				startX = N-1; 
				startY = i%N; 
				break;
			case 2:
				startX = N - (i%N) - 1;
				startY = N-1; 
				break;
			case 3:
				startY = N - (i%N) - 1; 
			}
			int plus = pitchBall(startX, startY, dir, board); 
			res += (plus * plus);
			
//			System.out.println("공 발사 후 ~");
//			System.out.println(plus);
//			print(board); 
		}
		
		bw.write(String.valueOf(res));
		bw.flush();
	}

	private static int pitchBall(int startX, int startY, int dir, int[][] board) {
		
		for(int i=0; i<N; i++) {
			int xn = startX + (i * dx[dir]); 
			int yn = startY + (i * dy[dir]);
			if(board[xn][yn] > 0 && board[xn][yn] < 4) {
				return bfs(xn, yn, board, new boolean[N][N]); 
			}
		}
		return 0; 
	}

	private static int bfs(int x, int y, int[][] board, boolean[][] visit) {

		Queue<Position> que = new LinkedList<>(); 
		que.add(new Position(x, y)); 
		visit[x][y] = true; 
		int depth = 1; 
		
		while(!que.isEmpty()) {
			int size = que.size();
			for(int i=0; i<size; i++) { 
				Position cur = que.poll();
				visit[cur.x][cur.y] = true; 
				if(board[cur.x][cur.y] == 1 ) {
					reverseHead(cur.x, cur.y, board);
					return depth; 
				} 
				for(int t=0; t<4; t++) {
					int xn = cur.x + dx[t];
					int yn = cur.y + dy[t]; 
					if(xn < 0 || xn >=N || yn <0 || yn >= N || board[xn][yn] == 0 || board[xn][yn] == 4 || board[xn][yn] == 3 || visit[xn][yn]) continue; 
					if(board[cur.x][cur.y] == 3 && board[xn][yn] == 1 ) {
						continue; 
					}
					visit[xn][yn] = true; 
					que.add(new Position(xn, yn)); 
				}
			}
			depth += 1; 
		}
		return 0; 
		
	}

	private static void reverseHead(int x, int y, int[][] board) {
		int idx = 0; 
		for(int i=0; i<M; i++) {
			if(x == head[i].x && y == head[i].y) {
				idx = i; 
				break; 
			}
		}
		
		Queue<Position> que = new LinkedList<>(); 
		boolean[][] visit = new boolean[N][N];
		que.add(head[idx]); 
		
		while(!que.isEmpty()) {
			Position cur = que.poll();
			if(board[cur.x][cur.y] == 3 ) {
				board[cur.x][cur.y] = 1;
				board[x][y] = 3; 
				head[idx] = cur; 
				return; 
			}
			visit[cur.x][cur.y] = true; 
			for(int t=0; t<4; t++) {
				int xn = cur.x + dx[t];
				int yn = cur.y + dy[t]; 
				if(xn < 0 || xn >=N || yn <0 || yn >= N || board[xn][yn] == 0 || board[xn][yn] == 4 || visit[xn][yn]) continue; 

				que.add(new Position(xn, yn)); 
				break; 
				
			}
		}
		
	}

	private static void print(int[][] board) {
		// TODO Auto-generated method stub
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}

	private static void moveTeam(int[][] board) {
		
		for(int i=0; i<M; i++) {
			Queue<Position> que = new LinkedList<>(); 
			boolean[][] visit = new boolean[N][N];
			que.add(head[i]); 
			
			while(!que.isEmpty()) {
				Position cur = que.poll();
				visit[cur.x][cur.y] = true; 
				for(int t=0; t<4; t++) {
					int xn = cur.x + dx[t];
					int yn = cur.y + dy[t]; 
					if(xn < 0 || xn >=N || yn <0 || yn >= N || board[xn][yn] == 0 || visit[xn][yn]) continue; 
					if(board[cur.x][cur.y] == 1 && (board[xn][yn] == 4 || board[xn][yn] == 3)) {
						board[cur.x][cur.y] = 2; 
						head[i] = new Position(xn, yn); 
						que.add(new Position(xn, yn));
						break; 
					}
					if(board[cur.x][cur.y] == 3 && board[xn][yn] == 2 ) {
						board[cur.x][cur.y] = 4; 
						board[xn][yn] = 3; 
						que.clear();
						break; 
					}
					if(board[xn][yn] != 2 && !visit[xn][yn]) {
						que.add(new Position(xn, yn)); 
						break; 
					}
				}
			}
			board[head[i].x][head[i].y] = 1;  
			
		}
		
	}

}
