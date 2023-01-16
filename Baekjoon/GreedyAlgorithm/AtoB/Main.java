package AtoB;

import java.util.*;
import java.io.*;

public class Main {

    public static int change(int cnt, Long A, Long B){
        if(A>B) return -1;
        if(A.equals(B)) return cnt;
        int m1 = change(cnt+1, A*2, B);
        int m2 = change(cnt+1, A*10+1, B);
        if(m1==m2&&m1==-1) return -1;
        else if(m1 == -1) return m2;
        else if(m2 == -1) return m1;
        return Math.min(m1,m2);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Long A = Long.parseLong(st.nextToken());
        Long B = Long.parseLong(st.nextToken());
        int cnt = change(1, A, B);

        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
