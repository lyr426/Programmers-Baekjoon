package 친구비;

import java.util.*;
import java.io.*;

public class Main {

    static int[] price;
    static boolean[] friend;
    static ArrayList<Integer>[] list;

    public static int minPrice(int i, int min){
        for(int x: list[i]){
            if(friend[x]) continue;
            friend[x] = true;
            min = minPrice(x, Math.min(min, price[x]));
        }
        return min;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;
        price = new int[N];
        friend = new boolean[N];
        list = new ArrayList[N];
        for(int i=0; i<N; i++) list[i] = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) price[i] = Integer.parseInt(st.nextToken());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            list[from].add(to);
            list[to].add(from);
        }
        for(int i=0; i<N; i++){
            if(!friend[i]){
                int min = price[i];
                min = minPrice(i, min);
                answer += min;
            }
        }
        if(answer <= K) bw.write(String.valueOf(answer));
        else bw.write("Oh no");
        bw.flush();
    }
}
