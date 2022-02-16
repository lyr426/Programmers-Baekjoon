import java.util.*;
import java.io.*; 

public class Main {
	public static void main(String[] args) throws IOException{ 
		Scanner sc = new Scanner(System.in); 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		int cnt =0; 
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2]; 
		for(int i=0; i<N; i++) {
			String[] str = br.readLine().split(" "); 
			arr[i][0] = Integer.parseInt(str[0]);
			arr[i][1] = Integer.parseInt(str[1]); 
		}
		//Arrays.sort(arr, Comparator.comparing(num1 -> num1[1]));
		Arrays.sort(arr, (o1, o2)-> {
			if(o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
			else return Integer.compare(o1[1], o2[1]); 
		});
		int cur = 0; 
		for(int i=0; i<N; i++) {
			if(cur<=arr[i][0]) {
				cnt++;
				cur = arr[i][1];
			}
		}
		
		bw.write(String.valueOf(cnt));
		bw.flush();
    }
}