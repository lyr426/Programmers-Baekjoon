package 회사에있는사람;

import java.io.*;
import java.util.*;

public class Main {

    public static void main (String args[] ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Comparator<String> comparator = (s1, s2) -> s2.compareTo(s1);
        Map<String, String> map = new TreeMap<>(comparator);

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        for(String key : map.keySet()) {
            if(map.get(key).equals("enter")){
                bw.write(key + "\n");
            }
        }
        bw.flush();
        bw.close();

    }
}
