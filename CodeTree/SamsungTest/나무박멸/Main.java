package 나무박멸;

import java.util.*;
import java.io.*;
public class Main {
	
	static int N; 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken())+1;
		
		int[][] tree = new int[N][N]; 
		int[][] inhibition = new int[N][N]; 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				tree[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int res = 0; 
		for(int i=0; i<M; i++) {
			growTree(tree); 
//			print(tree);
			breedTree(tree, inhibition); 
//			print(tree);
			res += inhibit(tree, inhibition, K, C);
//			print(tree);
			minusInhibit(inhibition);
		}
		bw.write(String.valueOf(res));
		bw.flush();
	}

	private static void minusInhibit(int[][] inhibition) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(inhibition[i][j] <= 0 ) continue; 
				inhibition[i][j] -= 1; 
			}
		
		}
	}

	private static void print(int[][] tree) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(tree[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static int inhibit(int[][] tree, int[][] inhibition, int K, int C) {
		int[] dx = {-1, -1, 1, 1};
		int[] dy = {-1, 1, -1, 1}; 
		int max = 0; 
		int x = 0; 
		int y = 0; 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(tree[i][j] <= 0) continue; 
				int treeCnt = tree[i][j]; 
				for(int t=0; t<4; t++) {
					for(int p=1; p<=K; p++) {
						int xn = i + (dx[t]*p); 
						int yn = j + (dy[t]*p); 
						if(xn < 0 || xn >= N || yn < 0 || yn >= N || tree[xn][yn] <= 0) break; 
						treeCnt += tree[xn][yn]; 
//						System.out.println(tree[xn][yn]);
					}
				}
//				System.out.println();
//				System.out.println(treeCnt);
//				System.out.println();
				if(treeCnt > max) {
					max = treeCnt; 
					x = i; 
					y = j;
				}
				
			}
		}
		
		for(int t=0; t<4; t++) {
			for(int p=1; p<=K; p++) {
				int xn = x + (dx[t]*p); 
				int yn = y + (dy[t]*p); 
				if(xn < 0 || xn >= N || yn < 0 || yn >= N ) break;
				inhibition[xn][yn] = C;  
				if(tree[xn][yn] <= 0) break; 
				tree[xn][yn] = 0; 
			}
		}
		tree[x][y] = 0; 
		inhibition[x][y] = C; 
		return max; 
	}

	private static void breedTree(int[][] tree, int[][] inhibition) {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		int[][] plusTree = new int[N][N]; 
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(tree[i][j] <= 0 ) continue; 
				int cnt = 0;
				for(int t=0; t<4; t++) {
					int xn = i + dx[t]; 
					int yn = j + dy[t]; 
					if(xn < 0 || xn >= N || yn < 0 || yn >= N || tree[xn][yn] != 0 || inhibition[xn][yn] != 0 ) continue; 
					cnt += 1;
				}
				if(cnt == 0) continue; 
				int addTree = tree[i][j] / cnt; 
				for(int t=0; t<4; t++) {
					int xn = i + dx[t]; 
					int yn = j + dy[t]; 
					if(xn < 0 || xn >= N || yn < 0 || yn >= N || tree[xn][yn] != 0 || inhibition[xn][yn] != 0 ) continue; 
					plusTree[xn][yn] += addTree; 
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				tree[i][j] += plusTree[i][j]; 
			}
		}
	}

	private static void growTree(int[][] tree) {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(tree[i][j] <= 0) continue;
				int cnt = 0; 
				for(int t=0; t<4; t++) {
					int xn = i + dx[t]; 
					int yn = j + dy[t]; 
					if(xn < 0 || xn >= N || yn < 0 || yn >= N || tree[xn][yn] <= 0 ) continue; 
					cnt += 1; 
				}
				tree[i][j] += cnt; 
			}
			
		}
		
	}

}
