class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {}; 
        int[] su1_ans = {1, 2, 3, 4, 5}; 
        int[] su2_ans = {2, 1, 2, 3, 2, 4, 2, 5}; 
        int[] su3_ans = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; 
        int[] score =  {0, 0, 0};
        int num=0, cnt=0, max =-1; 
        
        for(int x: answers){
            if(x == su1_ans[num%su1_ans.length]) score[0]++; 
            if(x == su2_ans[num%su2_ans.length]) score[1]++; 
            if(x == su3_ans[num%su3_ans.length]) score[2]++; 
            num++; 
        }
        for(int i=0; i<3; i++){
            if(score[i]>max){
                cnt=1; 
                max = score[i];
                continue; 
            }
            cnt++; 
        }
        answer = new int[cnt]; 
        num = 0;
        for(int i=0; i<3; i++){
            if(max == score[i]) answer[num++] = i+1; 
        }
        
        return answer;
    }
}