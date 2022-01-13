class Solution {
    public static int DOWN = 1;
    public static int RIGHT = 2;
    public static int UP = 3;
    
    public int[] solution(int n) {
       int[][] triangle = new int[n][n];
       int cnt = 1;
       int num = n;
       int order = DOWN;
       int cur_x = 0, cur_y = 0;
       while(num>0){
           if(order == DOWN){
               for(int i=0; i<num; i++) triangle[cur_x+i][cur_y] = cnt++;
               num--;
               cur_x += num;
               cur_y++;
               order = RIGHT;
               continue;
           }
           if(order == RIGHT){
               for(int i=0; i<num; i++) triangle[cur_x][cur_y+i] = cnt++;
               num--;
               cur_y += num;
               cur_x--;
               order = UP;
               continue;
           }
           for(int i=0; i<num; i++) triangle[cur_x-i][cur_y-i] = cnt++;
           num--;
           cur_x -= num-1; cur_y-=num+1;
           order = DOWN;
       }
       int answer[] = new int[cnt-1];
       cnt = 0; 
        for(int i =0; i<n; i++){
            for(int j=0; j<n; j++){
               if(triangle[i][j] == 0) continue;
               answer[cnt++] = triangle[i][j];
            }
        }
        return answer;
    }
}