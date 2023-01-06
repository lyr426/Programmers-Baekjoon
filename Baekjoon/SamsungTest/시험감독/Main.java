package 시험감독;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
        int[] space = new int[N];

        for(int i=0; i<N; i++){
            space[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bufferedReader.readLine(), " ");
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Long result = 0L;

        for(int i=0; i<N; i++){
            space[i] = space[i]-B;
            if(space[i]<=0) continue;
            result = (Long)(result + (space[i]/C));
            if(space[i]%C > 0) result += 1;
        }

        bufferedWriter.write(String.valueOf(result+N));
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
