package 수묶기;

import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> positiveQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negativeQueue = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num > 0){
                positiveQueue.add(num);
                continue;
            }
            negativeQueue.add(num);
        }
        int sum = sumQueue(0, positiveQueue);
        sum = sumQueue(sum, negativeQueue);

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }

    private static int sumQueue(int sum, PriorityQueue<Integer> queue) {

        while (!queue.isEmpty()){
            int x1 = queue.poll();

            if(queue.isEmpty()){
                sum += x1;
                continue;
            }

            int x2 = queue.poll();

            if(x1 + x2 > x1 * x2) {
                sum += x1;
                queue.add(x2);
                continue;
            }
            sum += x1 * x2;
        }
        return sum;
    }
}
