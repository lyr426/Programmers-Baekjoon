package 최고의피자;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());
        Integer[] D = new Integer[N];
        for(int i=0; i<N; i++) D[i] = Integer.parseInt(br.readLine());
        int calorie = C;
        int max = calorie/A;
        Arrays.sort(D, Collections.reverseOrder());

        for(int i=0; i<N; i++){
            calorie += D[i];
            int K =  calorie/(A + B * (i+1));
            if(K >= max) max = K;
            else { break; }
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
