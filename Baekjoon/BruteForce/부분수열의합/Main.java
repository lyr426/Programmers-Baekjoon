package 부분수열의합;
import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        bruteforce(0, 0);

        int min = queue.remove();
        while (!queue.isEmpty()){
            int out = queue.remove();
            if(out == 0) continue;
            if(out - min > 1 ){
                break;
            }
            min = out;
        }
        bw.write(String.valueOf(min+1));
        bw.flush();
        bw.close();
    }

    private static void bruteforce(int index, int sum) {
        if(index == N) {
            queue.add(sum);
            return;
        }
        bruteforce(index+1, sum);
        bruteforce(index+1, sum+arr[index]);

    }
}
