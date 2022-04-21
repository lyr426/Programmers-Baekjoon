import java.util.*;
import java.io.*; 

public class Main {
    
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int k = -1; 
        for(int i=N-1; i>0; i--){
            if(arr[i] > arr[i-1]){
                k = i;
                break; 
            }
        }
        if(k==-1){bw.write(String.valueOf(-1)); }
        else{
            int min = arr[k]; 
            int ar_min = k; 
            for(int i=k; i<N; i++){
                if(arr[i] > arr[k-1] && arr[i] < min ){
                    min = arr[i];
                    ar_min = i;
                }
            }
            int tmp = arr[k-1];
            arr[k-1] = min; 
            arr[ar_min] = tmp; 
            for(int i= 0; i<(N-k)/2; i++){
                tmp = arr[k+i]; 
                arr[k+i] = arr[N-i-1];
                arr[N-i-1] = tmp;
            }
            for(int i=0; i<N; i++) bw.write(String.valueOf(arr[i]+" "));
        }
        bw.flush();
        bw.close();
    }
}