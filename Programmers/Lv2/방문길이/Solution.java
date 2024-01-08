package 방문길이;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        char[] directs = dirs.toCharArray();
        int max = 11;
        boolean[][][] visit = new boolean[max][max][4]; // U D R L
        int[] cur = {5, 5};
        int x = cur[1];
        int y = cur[0];

        for(char direct: directs){
            int num = 0;
            int curNum = 0;
            switch(direct){
                case 'U': // y - 1
                    if(y > 0){
                        y -= 1;
                    }
                    num = 0;
                    curNum = 1;
                    break;
                case 'D' :
                    if(y < max-1){
                        y += 1;
                    }
                    num = 1;
                    curNum = 0;
                    break;
                case 'R' :
                    if(x < max-1){
                        x += 1;
                    }
                    num = 2;
                    curNum = 3;
                    break;
                case 'L' :
                    if(x > 0){
                        x -= 1;
                    }
                    num = 3;
                    curNum = 2;
                    break;
            }
            if(x == cur[1] && y == cur[0]){
                continue;
            }
            if(!visit[y][x][curNum]){
                answer += 1;
                visit[cur[0]][cur[1]][num] = true;
                visit[y][x][curNum] = true;
            }
            cur[0] = y;
            cur[1] = x;
        }

        return answer;
    }
}