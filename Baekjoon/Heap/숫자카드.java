import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer sc = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            map.put(Integer.parseInt(sc.nextToken()), i);
        }
        int M = Integer.parseInt(br.readLine());
        sc = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++){
            if(map.containsKey(Integer.parseInt(sc.nextToken()))){
                bw.write("1 ");
                continue;
            }
            bw.write("0 ");
        }
        bw.flush();
        bw.close();
    }
}
