package 술래잡기;

import java.util.*;
import java.io.*; 

class Position{
	int x;
	int y;
	int dirOption; // 0: 좌우, 1 : 상하 
	int dir = 0;   // 0: 오른쪽, 아래쪽 1: 왼쪽, 위쪽 
	
	Position(int x, int y, int dirOption){
		this.x = x;
		this.y = y; 
		this.dirOption = dirOption; 
	}
	
	Position(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	
	static int N; 
	static int M; 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean tree[][] = new boolean[N][N];
		Position[] targets = new Position[M]; 
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken())-1;
			targets[i] = new Position(x, y, d); 
		}
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			tree[x][y] = true; 
		}
		
		int score = 0; 
		int seekerX = N/2;
		int seekerY = N/2; 
		int seekerDir = 0; 
		int cnt = 0;
		int rotateCnt = 1; 
		int twoCnt = 0; 
		int mode = 0; 
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1}; 
		
		for(int i=0; i<K; i++) {
//			System.out.println(seekerX+ "__" + seekerY);
			
			moveTarget(seekerX, seekerY, targets);
			seekerX += dx[seekerDir]; 
			seekerY += dy[seekerDir]; 
			cnt += 1; 
			
			if(mode == 0) {
				if(cnt == rotateCnt) {
					seekerDir = (seekerDir+1)%4; 
					cnt = 0; 
					twoCnt += 1; 
				}
				if(twoCnt == 2) {
					twoCnt = 0; 
					rotateCnt += 1; 
				}
			}else {
				if(cnt == rotateCnt) {
					seekerDir = seekerDir-1 < 0 ? 3 : seekerDir - 1;
					cnt = 0; 
					twoCnt += 1; 
				}
				if(twoCnt == 2) {
					twoCnt = 0; 
					rotateCnt -= 1; 
				}
				
			}
			
			if(seekerX == 0 && seekerY == 0) {
				mode = 1; 
				seekerDir = 2; 
				cnt = 0;
				rotateCnt -= 1; 
				twoCnt = -1;
			}
			if(seekerX == N/2 && seekerY == N/2) {
				mode = 0; 
				seekerDir = 0; 
				cnt = 0;
				rotateCnt = 1; 
				twoCnt = 0;
			}
			
			score += getScore(seekerX, seekerY, seekerDir, targets, tree, i+1);
		}
		bw.write(String.valueOf(score)); 
		bw.flush();

	}

	private static int getScore(int seekerX, int seekerY, int seekerDir, Position[] targets, boolean[][] tree, int round) {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1}; 
		int cnt = 0;
		
		Position[] seeker = new Position[3]; 		
		for(int i=0; i<3; i++) {
			int xn = seekerX + (i * dx[seekerDir]); 
			int yn = seekerY + (i * dy[seekerDir]);
			seeker[i] = new Position(xn, yn); 
//			System.out.println(seeker[i].x + " ? " + seeker[i].y);
		}
		
		for(int i=0; i<M; i++) {
			Position target = targets[i]; 
			if((target.x == -1 && target.y == -1) || tree[target.x][target.y]) continue; 
			
			for(int j=0; j<3; j++) {
				if(target.x == seeker[j].x && target.y == seeker[j].y) {
					target.x = -1; 
					target.y = -1; 
					cnt += 1; 
					break; 
				}
				
			}
			
		}
		
		return cnt * round;
	}

	private static void moveTarget(int seekerX, int seekerY, Position[] targets) {
		int[][] dx = {{0, 0}, {1, -1}}; 
		int[][] dy = {{1, -1}, {0, 0}}; 
		
		for(int i=0; i<M; i++) {
			Position target = targets[i]; 
			if(target.x == -1 && target.y == -1) {
				continue; 
			}
			int dist = Math.abs(seekerX - target.x) + Math.abs(seekerY - target.y); 
			if(dist > 3) {
				continue; 
			}
			int xn = target.x + dx[target.dirOption][target.dir]; 
			int yn = target.y + dy[target.dirOption][target.dir]; 
			if(xn < 0 || xn >= N || yn <0 || yn >=N ) {
				target.dir = (target.dir + 1)%2; 
				xn = target.x + dx[target.dirOption][target.dir]; 
				yn = target.y + dy[target.dirOption][target.dir]; 
			}
			if (xn == seekerX && yn == seekerY) {
				continue; 
			}
			target.x = xn ;
			target.y = yn; 
			
//			System.out.println(i + " 번째 도망자 위치 = " + target.x + " _ " + target.y);
		}
		
	}

}
