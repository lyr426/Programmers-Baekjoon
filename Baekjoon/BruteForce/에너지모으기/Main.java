package 에너지모으기;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        energy(list, 0);

        bw.write(String.valueOf(max));
        bw.close();
    }

    private static void energy(List<Integer> list, int sum) {
        if(list.size() <= 2) {
            if(max <= sum) {
                max = sum;
            }
            return;
        }
        for(int i=1; i<list.size()-1; i++) {
            int value = list.get(i-1) * list.get(i+1);
            int iValue = list.get(i);
            list.remove(i);
            energy(list, sum + value);
            list.add(i, iValue);
        }
    }


}
