import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split("");
        Arrays.sort(str, Collections.reverseOrder());
        for(int i=0; i<str.length; i++) bw.write(str[i]);
        bw.flush();
    }
}
