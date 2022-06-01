import java.util.*;
import java.io.*; 

public class Main {
    static final long mod = 1000000009L;
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        long[][] cnt = new long[100001][4]; 
        
        for(int i=1; i<=100000; i++){
            if(i-1>=0){
                cnt[i][1] = cnt[i-1][2] + cnt[i-1][3]; 
                if(i==1) cnt[i][1] = 1;
            }
            if(i-2>=0){
                cnt[i][2] = cnt[i-2][1] + cnt[i-2][3];
                if(i==2) cnt[i][2] = 1;
            }
            if(i-3>=0){
                cnt[i][3] = cnt[i-3][1] + cnt[i-3][2];
                if(i==3) cnt[i][3] = 1;
            }
            cnt[i][1] %= mod;
            cnt[i][2] %= mod;
            cnt[i][3] %= mod;
        }
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            cnt[num][0] = (cnt[num][1] + cnt[num][2] + cnt[num][3])%mod;
            bw.write(String.valueOf(cnt[num][0])+"\n");
        }
        
        bw.flush();
        bw.close();
    }
}