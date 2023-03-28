package 컨베이어벨트위의로봇;

import java.io.*;
import java.util.*;

class Pair{
    int durability;
    boolean robot;
    Pair(int durability, boolean robot){
        this.durability = durability;
        this.robot = robot;
    }
}


public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Pair> deque = new LinkedList<>();
        List<Pair> list = (List<Pair>) deque;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2*N; i++){
            deque.offerLast(new Pair(Integer.parseInt(st.nextToken()), false));
        }
        int result = 0;
        int cnt = 0;
        while ( cnt < K ){
            cnt = 0;
            deque.addFirst(deque.pollLast()); // 1. 2N에 위치한 컨베이어 벨트를 올리는 위치에 둠 (모든 컨베이어 벨트가 한칸씩 이동)
            list.get(N-1).robot = false;

            for (int i=N-2; i>=0; i--){
                if(!list.get(i+1).robot && list.get(i+1).durability > 0 && list.get(i).robot){
                    list.get(i).robot = false;
                    list.get(i+1).robot = true;
                    list.get(i+1).durability -= 1;
                }
            }
            list.get(N-1).robot = false;
            if(!deque.peek().robot && deque.peek().durability > 0){
                Pair pair = deque.pollFirst();
                pair.robot = true;
                pair.durability -= 1;
                deque.offerFirst(pair);
            }
            for(Pair pair : deque){
                if(pair.durability == 0) cnt++;
            }
            result++;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
