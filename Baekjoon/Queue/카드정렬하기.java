import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i=0; i<N; i++) que.add(Integer.parseInt(br.readLine()));
        int cnt = 0;
        while(que.size() != 1){
            int a = que.poll();
            int b = que.poll();
            cnt += a+b;
            que.add(a+b);
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
