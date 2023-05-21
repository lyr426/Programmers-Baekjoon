package 잃어버린괄호;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String[] str = s.split("-|\\+");
        String str2 = s.replaceAll("[0-9]", "");
        int idx = str2.indexOf("-");
        if(idx == -1) idx = str.length;

        int result = 0;
    
        for(int i=0; i<str.length; i++) {
            if(i <= idx ) {
                result += Integer.parseInt(str[i]);
            }else {
                result -= Integer.parseInt(str[i]);
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
