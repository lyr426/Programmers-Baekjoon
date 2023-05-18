package 문자열폭발;

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String bomb = br.readLine();
        int len = bomb.length();

        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            stack.push(c);
            if( c == bomb.charAt(len-1) && stack.size() >= len) {
                StringBuilder sb = new StringBuilder();
                for(int i=len-1; i>=0; i--) {
                    sb.append(stack.get(stack.size()-1-i));
                }
                if(sb.toString().equals(bomb)) {
                    for(int i=0; i<len; i++) {
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : stack) sb.append(c);
        if(sb.length() == 0) {bw.write("FRULA");}
        else {bw.write(sb.toString());}
        bw.flush();

        bw.flush();
    }
}
