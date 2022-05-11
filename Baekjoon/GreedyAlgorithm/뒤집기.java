import java.util.*;
import java.io.*;
public class Main {

    public static int count (String str, char change){
        char[] carr = str.toCharArray();
        int cnt = 0;
        for(int i=0; i< carr.length; i++){
            if(carr[i] == change) continue;
            while (i<carr.length && carr[i]!=change) i++;
            cnt++;
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int min = Math.min(count(str, '1'), count(str, '0'));
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}