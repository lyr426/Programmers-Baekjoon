package ATM;

import java.util.*;
import java.io.*; 

public class Main {
	public static void main(String[] args) throws IOException{ 
		Scanner sc = new Scanner(System.in); 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		int answer = 0;  
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N]; 
		String[] str = br.readLine().split(" "); 
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(str[i]); 
		Arrays.sort(arr);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<=i; j++) answer += arr[j];
		}
		
		bw.write(String.valueOf(answer));
		bw.flush();
    }
}