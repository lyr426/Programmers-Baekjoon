import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            int answer = 1;
            int M = Integer.parseInt(br.readLine());
            String[][] clothes = new String[M][2];
            for(int j=0; j<M; j++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                clothes[j][0] = st.nextToken();
                clothes[j][1] = st.nextToken();
            }
            for (String[] key : clothes) {
                map.put(key[1], map.getOrDefault(key[1], map.getOrDefault(key[1], 0)) + 1);
            }
            for (String key : map.keySet())  answer *= map.get(key) + 1;
            bw.write(String.valueOf(answer-1)+"\n");
        }
        bw.flush();
    }
}
