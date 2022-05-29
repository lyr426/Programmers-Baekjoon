import java.util.*;
import java.io.*; 

public class Main {
    
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] card = new int[N+1]; 
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
            card[i] = -1; 
        }
        for(int i=1; i<=N; i++){
            for(int j=1; j<=i; j++){
                if(card[i] == -1 || card[i]>card[i-j]+arr[j] )
                {
                    card[i] = card[i-j]+arr[j]; 
                }
            }
        }
        bw.write(String.valueOf(card[N])); 
        
        bw.flush();
        bw.close();
    }
}