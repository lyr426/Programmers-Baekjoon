package 톱니바퀴;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //톱니바퀴 입력 받기
        Deque<Integer>[] deque = (Deque<Integer>[]) new Deque[4];
        for(int i=0; i<4; i++){
            deque[i] = new LinkedList<>();
            String[] input = br.readLine().split("");
            for(int j=0; j<8; j++) {
                deque[i].offer(Integer.parseInt(input[j]));
            }
        }

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken())-1;
            int rot = Integer.parseInt(st.nextToken());
            int[] dir = new int[4];
            dir[num] = rot;

            int cur = num;
            while (cur > 0){
                cur = cur-1;
                if(getElement(deque[cur], 2) == getElement(deque[cur+1], 6)){
                    break;
                }else {
                    dir[cur] = dir[cur+1]*-1;
                }
            }
            cur = num;
            while (cur < 3){
                cur = cur+1;
                if(getElement(deque[cur], 6) == getElement(deque[cur-1], 2)){
                    break;
                }else{
                    dir[cur] = dir[cur-1]*-1;
                }
            }

            for(int j=0; j<4; j++){
                if(dir[j] == 1){
                    deque[j].offerFirst(deque[j].pollLast());
                }else if(dir[j] == -1){
                    deque[j].offerLast(deque[j].pollFirst());
                }
            }
        }
        int result = 0;
        for(int i=0; i<4; i++){
            if(deque[i].pollFirst() == 1){
                result += (int)(Math.pow(2, i));
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static int getElement(Deque<Integer> integers, int check) {

        List list = (List) integers;
        return (int)list.get(check);
    }

}
