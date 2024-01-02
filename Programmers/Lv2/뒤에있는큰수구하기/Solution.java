package 뒤에있는큰수구하기;

import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        answer[len-1] = -1;

        for(int i=len-2; i>=0; i--) {
            if(numbers[i] < numbers[i+1]) {
                answer[i] = numbers[i+1];
            }else {
                if(answer[i+1] == -1) {
                    answer[i] = -1;
                    continue;
                }
                for(int j=i+1; j<len; j++){
                    if(numbers[i] < answer[j]){
                        answer[i] = answer[j];
                        break;
                    }
                    answer[i] = -1;
                }
            }
        }



        return answer;
    }
}