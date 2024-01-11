package DNA;

import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[] newc ={'A', 'C', 'G', 'T'};
        String[] dna = new String[N];
        String s = "";
        int total = 0;
        for(int i=0; i<N; i++) dna[i] = br.readLine();
        for(int i=0; i<M; i++){
            int min = -1;
            String str = "";
            for(int j=0; j<4; j++){
                int cnt = 0;
                char c = newc[j];
                for(int k=0; k<N; k++){
                    if(c != dna[k].charAt(i)) cnt++;
                }
                if(min == -1 || min > cnt){
                    min = cnt;
                    str = String.valueOf(c);
                }
            }
            s += str;
            total += min;
        }

        bw.write(s+"\n");
        bw.write(String.valueOf(total));
        bw.flush();
    }
}
