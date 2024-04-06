package 루돌프의반란;


import java.util.*;
import java.io.*;

class Santa{
	int num; 
	int x; 
	int y; 
	int sturn; 
	int score; 
	boolean survive; 
	
	Santa(int num, int x, int y, int sturn){
		this.num = num;
		this.x = x;
		this.y = y; 
		this.sturn = sturn; 
		this.survive = true; 
		this.score = 0; 
	}
	
}
public class Main {
	
	static int rudolfX;
	static int rudolfY;
	static int N; 
	static int M; 
	static int fail = 0; 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " "); 
		rudolfX = Integer.parseInt(st.nextToken())-1;
		rudolfY = Integer.parseInt(st.nextToken())-1;
		
		Santa[] santas = new Santa[P]; 
		for(int i=0; i<P; i++) {
			st = new StringTokenizer(br.readLine(), " "); 
			int num = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			santas[num-1] = new Santa(num, x, y, -2); 
		}
		for(int i=0; i<M; i++) {
			moveRudolf(santas, C, i);
			moveSanta(santas, D, i); 
			if(fail == P) {
				break; 
			}
			scorePlus(santas); 
		}
		

		for(Santa santa : santas) {
			bw.write(String.valueOf(santa.score+" "));
		} 
		
		bw.flush();
	}
	
	private static void scorePlus(Santa[] santas) {
		
		for(Santa santa : santas) {
			if(santa.survive) {
				santa.score += 1; 
			}
		}
		
	}

	private static void print(Santa[] santas) {
		System.out.println("rudolf = " + rudolfX + "__" + rudolfY);
		
		for(Santa santa : santas) {
			System.out.println(santa.num +" = " + santa.x + " ___ " + santa.y);
		}
		System.out.println();
	}

	private static void moveSanta(Santa[] santas, int D, int turn) {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1}; 
		
		for(Santa santa : santas) { // 번호가 높은 순서대로 
			if(!santa.survive || santa.sturn + 1 >= turn ) {
				continue; 
			}
			int dist = (rudolfX - santa.x)*(rudolfX - santa.x) + (rudolfY - santa.y)*(rudolfY - santa.y); 
			int minDist = Integer.MAX_VALUE; 
			int[] dir = new int[2]; 
			for(int i=0; i<4; i++) {
				int xn = santa.x + dx[i]; 
				int yn = santa.y + dy[i]; 
				if(xn < 0 || xn >= N || yn < 0 || yn >= N || isSanta(xn, yn, santas)) {
					continue;
				}
				int dist2 = (rudolfX - xn)*(rudolfX - xn) + (rudolfY -yn)*(rudolfY - yn); 
				if(dist > dist2 && minDist > dist2) {
					dir[0] = dx[i]*-1;
					dir[1] = dy[i]*-1; 
					minDist = dist2; 
				}
			}
			santa.x -= dir[0];
			santa.y -= dir[1]; 
			if(rudolfX == santa.x && rudolfY == santa.y) {
				getScore(santa, santas, D, dir, turn); 
			}
			
		}
		
		
	}

	private static boolean isSanta(int xn, int yn, Santa[] santas) {
		
		for(Santa santa : santas) {
			if(santa.x == xn && santa.y == yn) {
				return true;
			}
		}
		
		return false;
	}

	private static void moveRudolf (Santa[] santas, int C, int turn) {
		
		Santa target = new Santa(0,0,0,0);
		int minDist = Integer.MAX_VALUE; 
		for(Santa santa : santas) {
			if(!santa.survive) {
				continue; 
			}
			int dist = (rudolfX - santa.x)*(rudolfX - santa.x) + (rudolfY - santa.y)*(rudolfY - santa.y); 
			if(dist > minDist) {
				continue;
			}
			if(dist == minDist) { 
				if(santa.x == target.x ) {
					if(santa.y < target.y) {
						continue; 
					}
				}
				if(santa.x < target.x) {
					continue; 
				}
			}
			minDist = dist; 
			target = santa; 
		}
		
		int[] dir = new int[2]; 
		if(target.x < rudolfX) {
			rudolfX -= 1; 
			dir[0] -= 1; 
		}else if(target.x > rudolfX) {
			rudolfX += 1;
			dir[0] +=1; 
		}
		
		if(target.y < rudolfY) {
			rudolfY -= 1; 
			dir[1] -=1; 
		}else if(target.y > rudolfY) {
			rudolfY += 1; 
			dir[1] +=1; 
		}
		
		if(rudolfX == target.x && rudolfY == target.y) {
			getScore(target, santas, C, dir, turn); 
		}
		
	}
	

	private static void getScore(Santa target, Santa[] santas, int C, int[] dir, int turn) {
		target.score += C; 
		target.sturn = turn; 
		target.x += dir[0] * C; 
		target.y += dir[1] * C; 
		if(target.x < 0 || target.x >= N || target.y < 0 || target.y >= N) {
			target.survive = false; 
			fail += 1; 
			return; 
		}
		Queue<Santa> que = new LinkedList<>(); 
		que.add(target); 
		
		while(!que.isEmpty()) {
			Santa santa = que.poll();
			for(Santa difSanta : santas) {
				if(difSanta == santa) {
					continue; 
				}
				if(difSanta.x == santa.x && difSanta.y == santa.y) {
					difSanta.x += dir[0];
					difSanta.y += dir[1]; 
					if(difSanta.x < 0 || difSanta.x >= N || difSanta.y < 0 || difSanta.y >= N) {
						difSanta.survive = false; 
						fail += 1; 
						return; 
					}
					que.add(difSanta); 
				}
			}
		}
	}
	
	

}
