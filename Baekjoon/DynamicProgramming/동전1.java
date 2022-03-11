import java.util.*;
import java.io.*; 

public class Main {
    	public static void main(String[] args) throws IOException{ 
		Scanner sc = new Scanner(System.in); 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]); 
		int[] arr = new int[N]; 
		int[] d = new int[K+1]; 
		
		d[0] = 1; 
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for (int j = arr[i]; j <= K; j++) d[j] += d[j - arr[i]];
        }
		bw.write(String.valueOf(d[K]));
		bw.flush();
    }
}