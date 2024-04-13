package 예술성;

import java.util.*;
import java.io.*;
public class Main {
	
	static int N; 
	static int[] dx = {-1, 0, 1, 0}; 
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N]; 
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int res = 0; 
		for(int i=0; i<4; i++) {
			if(i > 0) {
				board = rotateBoard(board);
//				print(board);
			}
			int[][] group = new int[N][N]; 
			int[] blockValue = new int[N*N]; 
			int groupCnt = makeGroup(board, group, blockValue); 
//			print(group); 
			res += getScore(board, group, groupCnt, blockValue);
//			System.out.println(res);
			
		}
		
		bw.write(String.valueOf(res));
		bw.flush();
	}

	private static int[][] rotateBoard(int[][] board) {
		
		int size = (N-1)/2; 
		int[][] newBoard = new int[N][N];
		
		for(int i=0; i<N; i++) {
			newBoard[size][i] = board[i][size];
			newBoard[i][size] = board[size][N-i-1]; 
		}
//		size -= 1; 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i == size || j == size ) continue;
				if(i > size && j > size) {
					newBoard[j][N-i + size] = board[i][j];
					continue;
				}
				if(j > size) {
					newBoard[j-(size+1)][N-1-i] = board[i][j]; 
					continue; 
				}
				if(i > size) {
					newBoard[j+size+1][N-1-i] = board[i][j]; 
					continue; 					
				}
				newBoard[j][size-1-i] = board[i][j]; 
			}
		}
		return newBoard; 
	}

	private static int getScore(int board[][] ,int[][] group, int groupCnt, int[] blockValue) {
		int[] blockCnt = new int[groupCnt];
		int[][] contactCnt = new int[groupCnt][groupCnt]; 
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int num = group[i][j]; 
				blockCnt[num] += 1; 
				
				for(int k=0; k<4; k++) {
					int xn = i + dx[k];
					int yn = j + dy[k];
					if(xn < 0 || xn >= N || yn < 0 || yn >=N) {
						continue; 
					}
					contactCnt[num][group[xn][yn]] += 1; 
				}
				
			}
		}
		int score = 0;
		
		for(int i=0; i<groupCnt; i++) {
			for(int j=0; j<groupCnt; j++) {
				if( i == j ) continue; 
				score += (blockCnt[i] + blockCnt[j]) * blockValue[i] * blockValue[j] * contactCnt[i][j];
			}
		}
		
		return score/2; 
	}

	private static void print(int[][] group) {
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(group[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static int makeGroup(int[][] board, int[][] group, int[] blockValue) {
	
		boolean[][] visit = new boolean[N][N]; 
		int cnt = 0; 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j]) {
					blockValue[cnt] = board[i][j];
					dfs(cnt++, board, group, visit, i, j); 
				}
			}
		}
		
		return cnt;
	}

	private static void dfs(int cnt, int[][] board, int[][] group, boolean[][] visit, int x, int y) {
		if(visit[x][y]) {
			return; 
		}
		group[x][y] = cnt; 
		visit[x][y] = true; 
		for(int i=0; i<4; i++) {
			int xn = x + dx[i];
			int yn = y + dy[i]; 
			if(xn < 0 || xn >= N || yn < 0 || yn >= N || board[x][y] != board[xn][yn] || visit[xn][yn]) {
				continue; 
			}
			dfs(cnt, board, group, visit, xn, yn); 
		}
	}

}
