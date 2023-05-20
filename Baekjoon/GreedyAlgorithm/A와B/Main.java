package A와B;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        String T = br.readLine();

        bw.write(String.valueOf(operator(S, T)));
        bw.flush();
        bw.close();
    }

    private static int operator(String s, String t) {
        if(s.length() == t.length()) {
            if(s.equals(t)) return 1;
            return 0;
        }
        if(t.endsWith("B")){
            StringBuffer sb = new StringBuffer(t.substring(0, t.length()-1));
            String t1 = sb.reverse().toString();
            return operator(s, t1);
        }else {
            return operator(s,t.substring(0, t.length()-1));
        }
    }
}
