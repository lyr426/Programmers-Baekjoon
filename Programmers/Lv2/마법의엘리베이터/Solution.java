package 마법의엘리베이터;
class Solution {
    public int solution(int storey) {
        int answer = 0;
        int cur = storey;

        while(cur > 0) {
            int num = cur % 10;
            cur /= 10;
            if(num > 5 || (num == 5 && cur%10 >= 5)){
                answer += 10 - num;
                cur += 1;
            }else {
                answer += num;
            }
            System.out.println(answer);
        }
        return answer;
    }
}