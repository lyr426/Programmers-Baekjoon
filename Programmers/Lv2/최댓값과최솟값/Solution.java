package 최댓값과최솟값;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] number = s.split(" "); 
        int max = Integer.parseInt(number[0]); 
        int min = Integer.parseInt(number[0]); 

        for(String str: number){
            int num = Integer.parseInt(str); 
            if(num > max) max = num;
            if(num < min) min = num; 
        }
        answer += String.valueOf(min)+" ";
        answer += String.valueOf(max);
        return answer;
    }
}