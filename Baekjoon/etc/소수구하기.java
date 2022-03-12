import java.util.*;
import java.io.*; 
public class Main {
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M, N; 
        M = Integer.parseInt(st.nextToken()); 
        N = Integer.parseInt(st.nextToken()); 
        boolean[] check = new boolean[N+1];
        for(int i=2; i<=N; i++){
            if(check[i] == false){
                if(i>=M) {bw.write(String.valueOf(i)+'\n');} 
                for(int j=i*2; j<=N; j+=i) check[j] = true; 
            }
        }
        bw.flush();
        bw.close();
    }
}