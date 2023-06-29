package 순회공연;
import java.io.*;
import java.util.*;


class Lecture implements Comparable<Lecture>{
    int p;
    int d;

    Lecture (int p, int d) {
        this.p = p;
        this.d = d;
    }

    @Override
    public int compareTo(Lecture lecture){
        return lecture.p - this.p;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Lecture> queue = new PriorityQueue<>();

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            queue.add(new Lecture(p, d));
        }

//        HashMap<Integer, Integer> map = new HashMap<>();
        boolean[] visit = new boolean[10001];
        while (!queue.isEmpty()){
            Lecture lecture = queue.remove();
            int p = lecture.p;
            int d = lecture.d;

            while (visit[d] && d > 0) {
                d-=1;
            }
            if(!visit[d] && d >= 1){
                visit[d] = true;
                result += p;
            }

//            while (map.get(d) != null && d > 0) {
//                d -= 1;
//            }
//            if(map.get(d) == null && d >= 1){
//                map.put(d, p);
//                result += p;
//            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
