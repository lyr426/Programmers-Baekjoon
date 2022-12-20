package 요세푸스문제0;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Deque<Integer> que = new LinkedList<>();
        for(int i=1; i<=N; i++) que.addLast(i);
        System.out.print("<");
        while (!que.isEmpty()){
            for(int i=0; i<K-1; i++) que.addLast(que.removeFirst());
            System.out.print(que.removeFirst());
            if(!que.isEmpty()) System.out.print(", ");
        }
        System.out.print(">");
    }
}
