package 보석도둑;

import java.io.*;
import java.util.*;


class Jewelry implements Comparable<Jewelry>{
    Long weigh;
    Long price;

    Jewelry(Long weigh, Long price){
        this.weigh = weigh;
        this.price = price;
    }
    @Override
    public int compareTo(Jewelry o) {
        if(this.price == o.price){
            return this.weigh >= o.weigh ? 1 : -1;
        }
        return this.price < o.price ? 1 : -1;
    }
}

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewelry> queue = new PriorityQueue<>();
        ArrayList<Long> bag = new ArrayList<>();

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            Long m = Long.parseLong(st.nextToken());
            Long v = Long.parseLong(st.nextToken());
            queue.offer(new Jewelry(m, v));
        }
        for (int i=0; i<K; i++){
            bag.add(Long.parseLong(br.readLine()));
        }

        Collections.sort(bag);

        int sum = 0;
        while (!queue.isEmpty()){
            Jewelry jewelry = queue.poll();
            for (int i=0; i<bag.size(); i++){
                if(bag.get(i) >= jewelry.weigh){
                    sum += jewelry.price;
                    bag.remove(i);
                    break;
                }
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
