package 숫자게임;

import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int lose = 0;
        for(int i=0; i<n; i++){
            for(int j=lose; j<n; j++){
                if(A[i]<B[j]){
                    answer++;
                    lose = j+1;
                    break;
                }
            }
            if(A[i]>B[n-1]) return answer;
        }
        return answer;
    }
}