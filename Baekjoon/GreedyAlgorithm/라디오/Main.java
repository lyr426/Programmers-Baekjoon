package 라디오;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        int min = Math.abs(A-B);
        for(int i=0; i<N; i++){
            int K = Integer.parseInt(br.readLine());
            if(min > Math.abs(K-B)+1) min = Math.abs(K-B)+1;
        }
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}