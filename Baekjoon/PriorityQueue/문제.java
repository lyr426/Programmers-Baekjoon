import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [][] score = new int[N][2];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            score[i][0] = Integer.parseInt(st.nextToken());
            score[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(score, (o1, o2)->{
            if(o1[0] == o2[0]) return Integer.compare(o2[1], o1[1]);
            else return Integer.compare(o1[0], o2[0]);
        });
        PriorityQueue<Integer> sum = new PriorityQueue<>();
        sum.add(score[0][1]);
        for(int i=1; i<N; i++){
            if(score[i-1][0] == score[i][0] && sum.size() >= score[i][0]){
                if(score[i][1]>=sum.peek()){
                    sum.remove();
                    sum.add(score[i][1]);
                }
                continue;
            }
            sum.add(score[i][1]);
        }
        int answer = 0;
        for(int x: sum) answer += x;
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
