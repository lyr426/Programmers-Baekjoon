package 경사로;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static public int N;
    static public int L;

    public static void main(String args[]) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        Integer[][] map = new Integer[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 2*N;

        for (int i=0; i<N; i++) {
            List<Integer> list = Stream.of(map[i]).collect(Collectors.toList());
            cnt = slope(list)? cnt : cnt-1;

            int finalI = i;
            List<Integer> columnList = Arrays.stream(map)
                    .map(row -> row[finalI])
                    .collect(Collectors.toList());
            cnt = slope(columnList)? cnt : cnt-1;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    private static boolean slope(List<Integer> list) {
        boolean[] flag = new boolean[N];
        for(int i=0; i<N-1; i++){
            if(list.get(i) == list.get(i+1)) continue;
            if(list.get(i)+1 == list.get(i+1)) { // i가 1 더 작을 때
                for(int k=0; k<L; k++) {
                if(i-k >=0 && list.get(i) == list.get(i-k) && !flag[i-k]){
                    flag[i-k] = true;
                }else {
                    return false;
                }
            }
            }else if (list.get(i)-1 == list.get(i+1)) { // i가 1 더 클 때
                for(int k=0; k<L; k++) {
                    if (i+1+k < N && list.get(i+1) == list.get(i+1+k) && !flag[i+1+k]) {
                        flag[i+1+k] = true;
                    } else {
                        return false;
                    }
                }
            }else {
                return false;
            }
        }
        return true;
    }
}
