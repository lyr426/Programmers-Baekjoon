package 차량번호판1;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] chars = br.readLine().toCharArray();

        long result = 1;
        for(int i=0; i<chars.length; i++) {
            int num = chars[i] == 'c' ? 26 : 10;
            if(i != 0) {
                if(chars[i-1] == chars[i]) {
                    num -= 1;
                }
            }
            result *= num;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
