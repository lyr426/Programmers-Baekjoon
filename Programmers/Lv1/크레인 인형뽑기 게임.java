import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();

        for(int x:moves){
            for(int i=0; i<board.length; i++){
                int doll = board[i][x-1];
                if(doll == 0) continue;
                board[i][x-1] = 0;
                if(!bucket.isEmpty() && doll == bucket.peek()){
                    bucket.pop();
                    answer+=2;
                    break;
                }
                bucket.push(doll);
                break;
            }
        }
        return answer;
    }
}