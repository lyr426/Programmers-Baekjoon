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

        Deque<Pair> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2*N; i++){
            deque.offerLast(new Pair(Integer.parseInt(st.nextToken()), false));
        }
        int result = 0;
        int cnt = 0;
        while ( cnt != K ){
            cnt = 0;
            deque.addFirst(deque.pollLast()); // 1. 2N에 위치한 컨베이어 벨트를 올리는 위치에 둠 (모든 컨베이어 벨트가 한칸씩 이동)

            System.out.println();
            for(int i=0; i<2*N; i++){ // 2. 로봇 이동
                Pair cur = deque.pollLast();
                if(i == N-1 && cur.robot) { //내리는 위치면 로봇 내리기
                    cur.robot = false;
                }else if(cur.robot && !deque.peek().robot && deque.peek().durability > 0 ){ // 로봇이 있으면서 로봇을 이동할 수 있으면
                    Pair pair = deque.pollFirst();
                    pair.durability -= 1;
                    pair.robot = true;
                    deque.offerFirst(pair);
                    cur.robot = false;
                }
                deque.offerFirst(cur);
            }

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
