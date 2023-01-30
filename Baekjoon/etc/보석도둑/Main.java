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

        Comparator<Long> comparator = (o1, o2) -> o1.compareTo(o2);
        Map<Long, Integer> bag = new HashMap<>();

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            Long m = Long.parseLong(st.nextToken());
            Long v = Long.parseLong(st.nextToken());
            queue.offer(new Jewelry(m, v));
        }
        for (int i=0; i<K; i++){
            Long w = Long.parseLong(br.readLine());
            bag.put(w, bag.getOrDefault(w, 0)+1);
        }

        int sum = 0;
        while (!queue.isEmpty()){
            Jewelry jewelry = queue.poll();
            for(Map.Entry<Long, Integer> entry : bag.entrySet()){
                Long key = entry.getKey();
                int value = entry.getValue();
                if(key>= jewelry.weigh && value > 0){
                    sum += jewelry.price;
                    bag.replace(key, value-1);
                    break;
                }
            }

        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
