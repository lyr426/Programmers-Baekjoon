package 나는야포켓몬마스터이다솜;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedHashMap<String, Integer> pokemon = new LinkedHashMap<>();
        for(int i=0; i<N; i++) pokemon.put(br.readLine(), i+1);
        String[] name =pokemon.keySet().toArray(new String[N]);
        for(int i=0; i<M; i++){
            String str  = br.readLine();
            if(str.charAt(0)>='0' && str.charAt(0)<='9'){
                bw.write(name[Integer.parseInt(str)-1]+"\n");
                continue;
            }
            bw.write(pokemon.get(str)+"\n");
        }
        bw.flush();
    }
}
