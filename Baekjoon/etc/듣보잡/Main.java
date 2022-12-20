package 듣보잡;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> people = new HashMap<>();
        ArrayList<String> answer = new ArrayList<>();
        for(int i=0; i<N; i++) people.put(br.readLine(), i);
        for(int i=0; i<M; i++) {
            String name = br.readLine();
            if(people.containsKey(name)){
                answer.add(name);
            }
        }
        Collections.sort(answer);
        bw.write(String.valueOf(answer.size())+"\n");
        for(String s: answer) bw.write(s+"\n");
        bw.flush();
    }
}
