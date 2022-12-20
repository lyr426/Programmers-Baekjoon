package 쇠막대기;

import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Stack<String> stack = new Stack<>(); 
        
        String str = br.readLine(); 
        String[] stick = str.split(""); 
        int len = str.length(); 
        int open =0, cnt=0, stick_num=0;
        
        for(int i=0; i<len; i++){
            if(stick[i].equals("(")){
                open++; 
            }
            else if(stick[i].equals(")")&&stick[i-1].equals("(")){
                open--;
                cnt+=open;
            }
            else {
                open--;
                stick_num++;
            }
        }
        cnt+=stick_num;
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close(); 
        
    }
}