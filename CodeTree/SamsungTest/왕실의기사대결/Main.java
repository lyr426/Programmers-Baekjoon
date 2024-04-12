package 왕실의기사대결;

import java.util.*; 
import java.io.*; 

class Knight{
	int x;
	int y;
	int h;
	int w;
	int k; 
	
	Knight(int x, int y, int h, int w, int k){
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w; 
		this.k = k; 
	}
}
public class Main {

	static int L;
	static int N; 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int[][] board = new int[L][L]; 
		int[][] horse = new int[L][L];
		int[] initHP = new int[N];
		Knight[] knight = new Knight[N]; 
		
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<L; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," "); 
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			knight[i] = new Knight(x, y, h, w, k); 
			initHP[i] = k; 
			for(int p=0; p<h; p++) {
				for(int q=0; q<w; q++) {
					horse[x+p][y+q] = i+1; 
				}
			}
		}
		
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			if(knight[num].x == -1 && knight[num].y == -1) continue; 
			moveKnight(num, dir, horse, board, knight); 
//			print(horse); 
		}
		int res = 0; 
		for(int i=0; i<N; i++) {
			if(knight[i].k > 0) {
				res += initHP[i] - knight[i].k;
			}
		}
		
		bw.write(String.valueOf(res));
		bw.flush();
		
		
	}
	private static void print(int[][] horse) {
		// TODO Auto-generated method stub
		for(int i=0; i<L; i++) {
			for(int j=0; j<L; j++) {
				System.out.print(horse[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	private static void moveKnight(int num, int dir, int[][] horse, int[][] board, Knight[] knight) {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1}; 
		Queue<Integer> que = new LinkedList<Integer>();
		boolean[] visit = new boolean[N]; 
		que.add(num); 
		visit[num] = true; 
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			Knight curKnight = knight[cur]; 
			int x = curKnight.x; 
			int y = curKnight.y; 
			for(int i=0; i<curKnight.h; i++) {
				for(int j=0; j<curKnight.w; j++) {
					int xn = x + i + dx[dir]; 
					int yn = y + j + dy[dir];
					if(xn <0 || xn >= L || yn < 0 || yn >= L || board[xn][yn] == 2) {
						return; 
					}
					int index = horse[xn][yn]-1; 
					if(index >= 0 && !visit[index]) {
						que.add(index); 
						visit[index] = true; 
					}
					
				}
			}
		}
		for(int i=0; i<N; i++) {
			if(!visit[i]) continue; 
			Knight cur = knight[i]; 
			for(int p=0; p<cur.h; p++) {
				for(int q=0; q<cur.w; q++) {
					if(horse[cur.x+p][cur.y+q] == i+1) {
						horse[cur.x+p][cur.y+q] = 0; 
					}
				}
			}
			cur.x = cur.x + dx[dir]; 
			cur.y = cur.y + dy[dir]; 
			for(int p=0; p<cur.h; p++) {
				for(int q=0; q<cur.w; q++) {
					int xn = cur.x + p;
					int yn = cur.y + q; 
					if(board[xn][yn] == 1 && i != num) {
						cur.k -= 1; 
					}
					horse[xn][yn] = i+1; 
				}
			}
			if(cur.k <= 0) {
				removeKnight(i, horse, knight); 
			}
		}
	}
	private static void removeKnight(int idx, int[][] horse, Knight[] knight) {
		Knight cur = knight[idx]; 
		for(int p=0; p<cur.h; p++) {
			for(int q=0; q<cur.w; q++) {
				horse[cur.x+p][cur.y+q] = 0; 
			}
		}
		cur.x = -1;
		cur.y = -1; 
	
	}

}
