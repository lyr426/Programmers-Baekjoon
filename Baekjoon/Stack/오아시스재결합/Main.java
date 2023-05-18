package 오아시스재결합;

import java.io.*;
import java.util.Stack;

class Pair{
    int num;
    int cnt;

    Pair(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<Pair> stack = new Stack<>();
        Long result = 0L;

        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(stack.isEmpty() ) {
                stack.push(new Pair(input, 1));
                continue;
            }
            Pair cur = stack.peek();
            if(cur.num > input) {
                result += 1;
                stack.push(new Pair(input, 1));
                continue;
            }
            if(cur.num < input) {
                while (!stack.isEmpty() && stack.peek().num < input) {
                    result += stack.peek().cnt; 
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    cur = stack.peek();
                    if(cur.num > input) {
                        result +=1;
                    }
                }
            }
            if(cur.num == input) {
                result += cur.cnt;
                stack.pop();
                if(!stack.isEmpty()) result +=1;
                stack.push(new Pair(input, cur.cnt+1));
                continue;
            }


            stack.push(new Pair(input, 1));
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
