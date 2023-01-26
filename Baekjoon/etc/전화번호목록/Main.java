package 전화번호목록;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static boolean check() throws IOException {

        int N = Integer.parseInt(br.readLine());
        ArrayList<String> phone = new ArrayList<>();

        for(int i=0; i<N; i++){
            phone.add(br.readLine());
        }

        Collections.sort(phone);
                
        for (int i=0; i<N-1; i++){
            String str1 = phone.get(i);
            String str2 = phone.get(i+1);
            if(str1.length() <= str2.length()){
                str2 = str2.substring(0, str1.length());
                if(str1.equals(str2)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            if(check()) bw.write("NO\n");
            else bw.write("YES\n");
        }

        bw.flush();
        bw.close();
    }
}
