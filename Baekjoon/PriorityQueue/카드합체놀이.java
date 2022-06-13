import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)minHeap.add(Long.parseLong(st.nextToken()));

        for(int i=0; i<M; i++){
            long a = minHeap.poll();
            long b = minHeap.poll();
            minHeap.add(a+b);
            minHeap.add(a+b);
        }
        long result = 0;
        for(int i=0; i<N; i++) result += minHeap.poll();
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
