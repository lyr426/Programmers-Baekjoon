package 수학숙제;

import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        LinkedList<BigInteger> list = new LinkedList<>();

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                String num = "";
                while (j<str.length() &&str.charAt(j) >= '0' && str.charAt(j)<='9'){
                    num+=str.charAt(j);
                    j++;
                }
                if(num.length()>0) list.add(new BigInteger(num));
            }
        }
        Collections.sort(list);
        for(BigInteger x:list) bw.write(String.valueOf(x)+"\n");
        bw.flush();
        bw.close();
    }
}