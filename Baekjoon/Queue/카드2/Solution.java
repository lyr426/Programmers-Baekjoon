package 카드2;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Deque<Integer> que = new LinkedList<>();
        for(int i=1; i<=N; i++) que.addLast(i);

        while(que.size() != 1){
            que.removeFirst();
            if(que.size()!=0) que.addLast(que.removeFirst());
        }
        System.out.println(que.peek());

    }

}
