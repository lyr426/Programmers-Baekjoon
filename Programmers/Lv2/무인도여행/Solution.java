package 무인도여행;
import java.util.*;

class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {

    public static int x;
    public static int y;
    public static boolean[][] visit;

    public int[] solution(String[] maps) {
        int[] answer = new int[1];
        List<Integer> list = new ArrayList<>();
        x = maps.length;
        y = maps[0].length();
        visit = new boolean[x][y];
        int[][] foods = new int[x][y];

        for(int i=0; i<x; i++){
            char[] chars = maps[i].toCharArray();
            for(int j=0; j<y; j++){
                if(chars[j] == 'X') {
                    foods[i][j] = 0;
                    continue;
                }
                foods[i][j] = chars[j] - '0';
            }
        }

        for(int i=0; i<x; i++) {
            for(int j=0; j<y; j++) {
                if(!visit[i][j] && foods[i][j] != 0) {
                    Queue<Pair> que = new LinkedList<>();
                    que.add(new Pair(i, j));
                    visit[i][j] = true;
                    list.add(bfs(foods, que));

                }
            }
        }
        if(list.size() == 0) {
            answer[0] = -1;
            return answer;
        }
        answer = list.stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);
        return answer;
    }

    private int bfs (int[][] foods, Queue<Pair> que){
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        int sum = 0;

        while(!que.isEmpty()){
            Pair pair = que.remove();
            int curX = pair.x;
            int curY = pair.y;
            sum += foods[curX][curY];

            for(int i=0; i<4; i++) {
                int xn = curX + dx[i];
                int yn = curY + dy[i];
                if(xn >= 0 && xn < x && yn >= 0 && yn < y){
                    if(!visit[xn][yn] && foods[xn][yn] != 0){
                        que.add(new Pair(xn, yn));
                        visit[xn][yn] = true;
                    }
                }
            }
        }
        return sum;

    }
}