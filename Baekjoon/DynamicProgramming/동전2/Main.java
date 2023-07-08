package 동전2;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] d = new int[K+1];

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            map.put(Integer.parseInt(br.readLine()), 0);
        }

        for(int i=1; i<=K; i++) {
            int min = Integer.MAX_VALUE;
            for(int x : map.keySet()){
                if(i >= x && d[i-x] != -1) {
                    min = Math.min(d[i-x]+1, min);
                }
            }
            d[i] = min != Integer.MAX_VALUE ? min : -1;
//          System.out.println("d[" + i + "]  = " + d[i]);
        }
        bw.write(String.valueOf(d[K]));
        bw.flush();
        bw.close();
    }
}
