package 부분수열의합;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int volume = 1;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            volume += arr[i];
        }
        visit = new boolean[volume+1];
        bruteforce(0, 0);

        int min = 1;
        while (visit[min]){
            min += 1;
        }
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }

    private static void bruteforce(int index, int sum) {
        if(index == N) {
            visit[sum] = true;
            return;
        }
        bruteforce(index+1, sum);
        bruteforce(index+1, sum+arr[index]);

    }
}
