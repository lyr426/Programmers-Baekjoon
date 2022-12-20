package 최대힙;

import java.util.*;
import java.io.*; 

public class Main {

	public static void main(String[] args) throws IOException{ 
		Scanner sc = new Scanner(System.in); 
		PriorityQueue que = new PriorityQueue<>(Collections.reverseOrder());
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			int x = sc.nextInt(); 
			if(x==0) {
				if(que.isEmpty()) System.out.println(0); 
				else System.out.println(que.poll()); 
				continue;
			}
			que.add(x); 
		}
    }
}