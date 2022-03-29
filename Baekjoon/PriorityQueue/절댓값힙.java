import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minusQue = new PriorityQueue<>();
        PriorityQueue<Integer> plusQue = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            int k = Integer.parseInt(br.readLine());
            if(k==0){
                if(minusQue.isEmpty() && plusQue.isEmpty()) bw.write("0"+"\n");
                else if(minusQue.isEmpty()) bw.write(String.valueOf(plusQue.remove())+"\n");
                else if(plusQue.isEmpty()) bw.write(String.valueOf(minusQue.remove()*-1)+"\n");
                else{
                    if(minusQue.peek() <= plusQue.peek()) bw.write(String.valueOf(minusQue.remove()*-1)+"\n");
                    else bw.write(String.valueOf(plusQue.remove())+"\n");
                }
                continue;
            }
            if(k > 0) plusQue.add(k);
            else minusQue.add(k*-1);
        }
        bw.flush();
    }
}
