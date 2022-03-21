import java.util.*;
import java.io.*; 

public class Main {


	public static void main(String[] args) throws IOException{ 
		Scanner sc = new Scanner(System.in); 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		PriorityQueue<Integer> minQue = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> maxQue = new PriorityQueue<Integer>(); 
		
		int n = Integer.parseInt(br.readLine());
		for(int i=1; i<=n; i++) {
			int k = Integer.parseInt(br.readLine());
			if( i%2 != 0 ) {// 홀수 => min 힙에 저장
				if( minQue.isEmpty() || k<minQue.peek()) minQue.add(k);
				else {
					maxQue.add(k);
					minQue.add(maxQue.poll()); 
				}
			}
			else if( i%2 == 0) {
				if( !maxQue.isEmpty() && k>maxQue.peek()) maxQue.add(k);
				else {
					minQue.add(k);
					maxQue.add(minQue.poll()); 
				}
			}
			bw.write(minQue.peek()+"\n");
		}
		bw.flush();
    }
}