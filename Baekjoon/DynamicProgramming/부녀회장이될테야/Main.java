package 부녀회장이될테야;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int test=0; test<T; test++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int [][] apt = new int[k+1][n+1];

            for(int i=0; i<=k; i++) {
                for(int j=1; j<=n; j++) {
                    if(i == 0) {
                        apt[i][j] = j;
                        continue;
                    }
                    apt[i][j] = apt[i][j-1] + apt[i-1][j];
                }
            }
            bw.write(String.valueOf(apt[k][n])+ "\n");

        }
        bw.flush();
        bw.close();
    }
}
