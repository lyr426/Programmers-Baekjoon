import java.util.*;
import java.io.*; 

public class Main {

    public static boolean pNum(int input){
        if(input < 2) return false;
        for(int i=2; i*i<=input; i++){
            if(input%i ==0) return false;
        }
        return true; 
    }

    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cnt=0; 
        for(int i=0; i<T; i++){
            int k = Integer.parseInt(st.nextToken()); 
            if(pNum(k)) cnt++;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}