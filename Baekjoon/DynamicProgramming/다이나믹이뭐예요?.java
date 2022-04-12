import java.util.*;
import java.io.*;

public class Main {

    static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] d = new int[n][m];
        d[0][0] = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i-1>=0 && j-1>=0) d[i][j] += d[i-1][j-1];
                d[i][j] %= MOD;
                if(i-1>=0) d[i][j] += d[i-1][j];
                d[i][j] %= MOD;
                if(j-1>=0) d[i][j] += d[i][j-1];
                d[i][j] %= MOD;
            }
        }
        bw.write(String.valueOf(d[n-1][m-1]%MOD));
        bw.flush();
    }
}
