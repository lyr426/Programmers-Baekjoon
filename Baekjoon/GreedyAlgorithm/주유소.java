import java.util.*;
import java.io.*; 

public class Main {
	public static void main(String[] args) throws IOException{ 
		Scanner sc = new Scanner(System.in); 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		long answer = 0;  
		int N = Integer.parseInt(br.readLine());
		int[][] oil= new int[N][2];
		
		for(int i=0; i<2; i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0; j<N-1; j++) {
				oil[j][i] = Integer.parseInt(str[j]);
			}
		}
		int cnt = 0; 
		for(int i=0; i<N-1; i+=cnt) {
			cnt =1;
			long distance = oil[i][0]; 
			while(oil[i][1] <= oil[i+cnt][1]) {
				distance += oil[i+cnt][0]; 
				cnt++; 
			}
			answer += oil[i][1] * distance; 
		}
		
		bw.write(String.valueOf(answer));
		bw.flush();
    }
}