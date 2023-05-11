package 부족한금액계산하기;

class Solution {
    public long solution(int price, int money, int count) {
        long answer = money; 
        for(int i=0; i<count; i++){
            answer -= (i+1) * price; 
        }
        if(answer >= 0) return 0;
        return answer*-1;
    }
}