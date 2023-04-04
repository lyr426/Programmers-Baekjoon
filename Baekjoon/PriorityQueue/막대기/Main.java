package 막대기;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int length = 64;
        PriorityQueue<Integer> stick = new PriorityQueue<>();
        stick.add(64);
        while (length != X) {
            int k = stick.poll()/2;
            if(length - k >= X) {
                stick.add(k);
                length -= k;
            }else {
                stick.add(k);
                stick.add(k);
            }

        }
        bw.write(String.valueOf(stick.size()));
        bw.flush();
        bw.close();

    }
}
