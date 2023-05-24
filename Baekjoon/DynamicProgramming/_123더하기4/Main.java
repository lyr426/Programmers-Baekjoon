package _123더하기4;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int input = Integer.parseInt(br.readLine());
            int[] d = new int[input+1];
            d[0] = 1;

            for(int j=1; j<=input; j++) {
                if(j<3){
                    d[j] = j/2 + 1;
                    continue;
                }
                d[j] = d[j-3] + j/2 + 1;

            }
            bw.write(String.valueOf(d[input]) + "\n");

        }
        bw.flush();
        bw.close();

    }

}
