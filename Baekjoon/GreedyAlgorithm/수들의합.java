import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long S = Long.parseLong(br.readLine());
        long sum = 0;
        long num = 1;
        while (sum < S){
            sum += num;
            num++;
            if(S-sum < num) break;
        }
        bw.write(String.valueOf(num-1));
        bw.flush();
    }
}
