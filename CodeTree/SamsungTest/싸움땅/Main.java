package 싸움땅;

import java.util.*;
import java.io.*; 

class Player{
	int x;
	int y; 
	int dir;
	int s; 
	int gun = 0; 
	int point = 0; 
	
	Player(int x, int y, int dir, int s){
		this.x = x;
		this.y = y;
		this.dir = dir; 
		this.s = s; 
	}
}
public class Main {
	
	static int N; 
	static int M; 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		StringTokenizer st = new StringTokenizer(br.readLine()," "); 
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer>[][] board = new PriorityQueue[N][N];
	
		Player[] players = new Player[M]; 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " "); 
			for(int j=0; j<N; j++) {
				board[i][j] = new PriorityQueue<Integer>(Collections.reverseOrder()); 
				int num = Integer.parseInt(st.nextToken()); 
				if(num > 0) {
					board[i][j].add(num); 
				}
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," "); 
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			players[i] = new Player(x, y, dir, s); 
		}
		
		for(int i=0; i<K; i++) {
//			System.out.println(i+"번째 라운드 !!!! ");
			movePlayer(players, board);
//			print(players);
//			System.out.println();
		}
		
		for(int i=0; i<M; i++) {
			bw.write(String.valueOf(players[i].point + " "));
		}
		bw.flush();
	}

	private static void print(Player[] players) {
		int ind = 1; 
		for(Player pla : players) {
			System.out.println(ind + "번째 참가자 ");
			System.out.println("x = " + pla.x + " y = " + pla.y + " gun = " + pla.gun);
			
			ind++; 
		}
	}

	private static void movePlayer(Player[] players, PriorityQueue<Integer>[][] board) {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1}; 
		
		for(int i=0; i<M; i++) {
			Player player = players[i]; 
			int xn = player.x + dx[player.dir];
			int yn = player.y + dy[player.dir];
			if(xn < 0 || xn >= N || yn < 0 || yn >= N) {
				player.dir = (player.dir + 2)%4; 
				xn = player.x + dx[player.dir];
				yn = player.y + dy[player.dir];
			}
			int index = isPlayer(xn, yn, players); 
			int winner = i; 
			player.x = xn;
			player.y = yn; 
			
			if( index >= 0) { // 플레이어가 있는 경우
				if(player.gun + player.s < players[index].gun + players[index].s) {
					winner = index; 
				}
				if(player.gun + player.s == players[index].gun + players[index].s) {
					if(player.s < players[index].s) {
						winner = index; 
					}
				}
				int loser = winner == i ? index : i; 
//				System.out.println("승자는 = " + winner + " 패자는 =" + loser );
				int point = Math.abs((player.gun + player.s) - (players[index].gun + players[index].s)); 
				players[winner].point += point; 
				if(players[loser].gun != 0) {
					board[xn][yn].add(players[loser].gun);
					players[loser].gun = 0; 
				} 
				
				for(int j=0; j<4; j++) {
					int dir = (players[loser].dir + j)%4; 
					int xn2 = players[loser].x + dx[dir]; 
					int yn2 = players[loser].y + dy[dir]; 
					if(xn2 < 0 || xn2 >= N || yn2 < 0 || yn2 >= N || isPlayer(xn2, yn2, players) >= 0) {
						continue; 
					}
					players[loser].x = xn2; 
					players[loser].y = yn2; 
					players[loser].dir = dir;
					int gun = players[loser].gun; 
					pickGun(players, board, xn2, yn2, loser);
					break; 
				}
			}
		
			pickGun(players, board, xn, yn, winner); 		
			
		}
		
	}

	private static void pickGun(Player[] players, PriorityQueue<Integer>[][] board, int x, int y, int index) {
		if(board[x][y].size() > 0 && board[x][y].peek() > players[index].gun) {
			int gun = players[index].gun;
			players[index].gun = board[x][y].poll(); 
			if(gun != 0) {
				board[x][y].add(gun); 
			}
		}		
		
	}

	private static int isPlayer(int xn, int yn, Player[] players) {
		
		for(int i=0; i<M; i++) {
			if(players[i].x == xn && players[i].y == yn) {
				return i; 
			}
		}
		return -1;
	}

}
