package AC;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            Deque<Integer> que = new ArrayDeque<>();
            boolean direction = true;
            boolean flag = false;
            char[] chars = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            str = str.substring(1, str.length()-1);
            String[] numbers = str.split(",");
            for(int j=0; j< n; j++) que.add(Integer.parseInt(numbers[j]));
            for(int j=0; j<chars.length; j++){
                if(chars[j] == 'R') direction = !direction;
                if(chars[j] == 'D'){
                    if(que.isEmpty()){
                        bw.write(String.valueOf("error"+"\n"));
                        flag = true;
                        break;
                    }
                    if(direction) que.removeFirst();
                    else if(!direction) que.removeLast();
                }
            }
            if(flag) continue;
            if(que.isEmpty()){
                bw.write(String.valueOf("[]"+"\n"));
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if(direction){
                while(!que.isEmpty()) sb.append(que.removeFirst()+",");
            }
            else while(!que.isEmpty()) sb.append(que.removeLast()+",");
            sb.deleteCharAt(sb.length()-1);
            sb.append("]"+"\n");
            bw.write(String.valueOf(sb.toString()));
        }
        bw.flush();
    }
}
