import java.util.*;
import java.io.*; 

public class Main {
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int arr[] = null; 
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        for(int val: arr){
            bw.write(String.valueOf(val));
            bw.newLine();
        }
        bw.flush();
    }
}