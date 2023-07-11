package 나3곱2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Long> list = new ArrayList<>();
    static boolean flag = false;
    static List<Long> res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            list.add(Long.parseLong(st.nextToken()));
        }

        for(int i=0; i<N; i++){
            long k = list.get(i);
            List<Long> tmpList = new ArrayList<>();
            tmpList.add(k);
            bruteForce(list, tmpList);
//            list.add(i, k);
        }

        for(Long x : res){
            bw.write(x + " ");
        }
        bw.flush();
        bw.close();
    }

    private static void bruteForce(List<Long> list, List<Long> curList) {
        Long lastNum = curList.get(curList.size()-1);
        if( flag || !list.contains(lastNum)){
            return;
        }
        if(curList.size() == N) {
            flag = true;
            res = new ArrayList<>(curList);
            return;
        }

        int idx = list.indexOf(lastNum);
        list.remove(idx);
        if(lastNum%3 == 0) {
            curList.add(lastNum/3);
            bruteForce(list, curList);
            curList.remove(curList.size()-1);
        }
        curList.add(lastNum*2);
        bruteForce(list, curList);
        curList.remove(curList.size()-1);
        list.add(idx,lastNum);
    }
}
