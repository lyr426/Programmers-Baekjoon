package 소수;

import java.util.*;
import java.io.*;

public class Main {
    public static boolean Pnum(int input){
        if(input < 2){return false;}
        for(int i=2; i*i<=input; i++){
            if(input%i ==0){return false;}
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int min = -1;
        for(int i=M; i<=N; i++){
            if(Pnum(i)){
                if(min == -1) min = i;
                answer += i;
            }
        }
        if(min == -1) bw.write("-1");
        else bw.write(String.valueOf(answer)+"\n"+String.valueOf(min));
        bw.flush();
        bw.close();
    }
}
