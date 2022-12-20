package 수찾기;

import java.util.*;
import java.io.*; 

public class main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int[] makeArray() throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String[] str = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i]  = Integer.parseInt(str[i]); 
		}
		return arr; 
	}
	
	private static boolean binarySearch(int[] arr, int n) {
		int left = 0, mid = 0 , right = arr.length-1; 
		while(left <= right) {
			mid = (left+right)/2; 
			if(arr[mid] == n) return true; 
			if(arr[mid] < n) left = mid+1;
			else if(arr[mid] > n) right = mid-1; 
		}
		return false; 
	}

	public static void main(String[] args) throws IOException{ 
		int[] arr = makeArray(); 
		Arrays.sort(arr);
		int [] question = makeArray(); 
		
		for(int x: question) {
			if(binarySearch(arr,x)) {
				bw.write(1+"\n");
				continue;
			}
			bw.write(0+"\n");
		}
		bw.flush();
    }
}