package 이모티콘;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int cnt;
    int emojiCnt;
    int clipboard;

    Pair(int cnt, int emojiCnt, int clipboard) {
        this.cnt = cnt;
        this.emojiCnt = emojiCnt;
        this.clipboard = clipboard;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int S = Integer.parseInt(br.readLine());
        int min = -1;
        boolean[][] visit = new boolean[10000][10000];
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(0, 1, 0));
        while (!queue.isEmpty()){
            Pair cur = queue.poll();
            if(visit[cur.emojiCnt][cur.clipboard]) continue;
            visit[cur.emojiCnt][cur.clipboard] = true;
            if(cur.emojiCnt == S) {
                min = cur.cnt;
                break;
            }
            queue.add(new Pair(cur.cnt+1, cur.emojiCnt, cur.emojiCnt));
            if(cur.clipboard != 0) {
                queue.add(new Pair(cur.cnt + 1, cur.emojiCnt + cur.clipboard, cur.clipboard));
            }
            if(cur.emojiCnt > 0) {
                queue.add(new Pair(cur.cnt + 1, cur.emojiCnt - 1, cur.clipboard));
            }

        }

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();

    }
}
