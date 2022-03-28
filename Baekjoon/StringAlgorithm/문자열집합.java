import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> hashMap = new HashMap<>();
        for(int i=0; i<N; i++) hashMap.put(i, br.readLine());
        for(int i=0; i<M; i++){
            String str = br.readLine();
            if(hashMap.containsValue(str)) answer++;
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
