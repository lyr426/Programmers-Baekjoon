package 포탑부수기;

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

class LazerInfo{
	Position position; 
	List<Position> route; 
	
	LazerInfo(Position position, List<Position> route){
		this.position = position;
		this.route = route; 
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
		int K = Integer.parseInt(st.nextToken());
		
		int[][] power = new int[N][M];
		int[][] recentAttack = new int[N][M]; 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," "); 
			for(int j=0; j<M; j++) {
				power[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<K; i++) {
			Position attacker = weakTurret(power, recentAttack); 
			Position target = strongTurret(power, recentAttack);
			if(attacker.x == target.x && attacker.y == target.y) {
				break;
			}
			power[attacker.x][attacker.y] += M+N; 
			List<Position> visitPosition = attack(attacker, target, power); 
			repair(visitPosition, power); 
			recentAttack[attacker.x][attacker.y] = i + 1;  
		}
		int max = -1; 
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(power[i][j] > max) {
					max = power[i][j]; 
				}
			}
		}
		bw.write(String.valueOf(max));
		bw.flush();
		
	}

	private static void print(int[][] power) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(power[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void repair(List<Position> visitPosition, int[][] power) {
		boolean[][] visit = new boolean[N][M];
		for(Position pos: visitPosition) {
			visit[pos.x][pos.y] = true;  
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visit[i][j] || power[i][j] <= 0) continue; 
				power[i][j] += 1; 
			}
		}
		
	}

	private static List<Position> attack(Position attacker, Position target, int[][] power) {
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0}; 
		
		Queue<LazerInfo> que = new LinkedList<>();
		que.add(new LazerInfo(attacker, new LinkedList<>())); 
		boolean[][] visit = new boolean[N][M]; 
		
		while(!que.isEmpty()) {
			LazerInfo lazerInfo = que.remove(); 
			int x = lazerInfo.position.x;
			int y = lazerInfo.position.y; 
			visit[x][y] = true; 
			lazerInfo.route.add(lazerInfo.position);
			if(x == target.x && y == target.y) {
				damage(attacker, target, lazerInfo.route, power); 
				return lazerInfo.route; 
			}
			
			for(int i=0; i<4; i++) {
				int xn = x + dx[i]; 
				int yn = y + dy[i];
				if(xn < 0) xn = N-1; 
				if(xn >= N) xn = 0; 
				if(yn < 0) yn = M-1; 
				if(yn >= M) yn = 0; 
				if(visit[xn][yn] || power[xn][yn] <= 0) continue; 
				List<Position> newList = new LinkedList<>();
				newList.addAll(lazerInfo.route); 
				que.add(new LazerInfo(new Position(xn, yn), newList));
			}
			
		}
		
		dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
		dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
		List<Position> visitPosition = new LinkedList<Position>(); 
		visitPosition.add(attacker); 
		
		int attackPower = power[attacker.x][attacker.y]; 
		for(int i=0; i<8; i++) {
			int xn = target.x + dx[i]; 
			int yn = target.y + dy[i];
			if(xn < 0) xn = N-1; 
			if(xn >= N) xn = 0; 
			if(yn < 0) yn = M-1; 
			if(yn >= M) yn = 0; 
			if(power[xn][yn] <= 0 || (xn == attacker.x && yn == attacker.y)) continue; 
			visitPosition.add(new Position(xn, yn)); 
			power[xn][yn] -= (attackPower/2); 
		}
		visitPosition.add(target); 
		power[target.x][target.y] -= attackPower; 
		return visitPosition; 
	}

	private static void damage(Position attacker, Position target, List<Position> route, int[][] power) {
			
		int attackPower = power[attacker.x][attacker.y]; 
		for(Position pos : route) {
			if(pos.x == attacker.x && pos.y == attacker.y) {
				continue; 
			}
			if(pos.x == target.x && pos.y == target.y) {
				power[pos.x][pos.y] -= attackPower; 
				continue; 
			}
			power[pos.x][pos.y] -= (attackPower/2); 
		}
		
	}

	private static Position strongTurret(int[][] power, int[][] recentAttack) {
		
		Position turret = new Position(-1, -1); 
		int maxPower = Integer.MIN_VALUE; 
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(power[i][j] <= 0) continue; 
				if(maxPower > power[i][j]) continue; 
				if(maxPower ==  power[i][j]) {
					if(recentAttack[i][j] > recentAttack[turret.x][turret.y]) continue; 
					if(recentAttack[i][j] == recentAttack[turret.x][turret.y]) {
						if(i + j > turret.x + turret.y) continue; 
						if(i + j == turret.x + turret.y) {
							if(j > turret.y) continue; 
						}
					}
				}
				maxPower = power[i][j]; 
				turret = new Position(i, j); 
			}
		}
		
		
		return turret;
	}

	private static Position weakTurret(int[][] power, int[][] recentAttack) {
		
		Position turret = new Position(-1, -1); 
		int minPower = Integer.MAX_VALUE; 
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(power[i][j] <= 0) continue; 
				if(minPower < power[i][j]) continue; 
				if(minPower ==  power[i][j]) {
					if(recentAttack[i][j] < recentAttack[turret.x][turret.y]) continue; 
					if(recentAttack[i][j] == recentAttack[turret.x][turret.y]) {
						if(i + j < turret.x + turret.y) continue; 
						if(i + j == turret.x + turret.y) {
							if(j < turret.y) continue; 
						}
					}
				}
				minPower = power[i][j]; 
				turret = new Position(i, j); 
			}
		}
		
		
		
		return turret;
	}

}
