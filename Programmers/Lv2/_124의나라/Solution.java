package _124의나라;

class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] numbers = {"1", "2", "4"};
        while(n>0) {
            if(n%3 == 0) {
                sb.insert(0, numbers[2]);
                n = n/3 - 1;
                continue;
            }
            sb.insert(0, numbers[n%3-1]);
            n /= 3;
        }
        System.out.println(sb.toString());
        answer = sb.toString();
        return answer;
    }
}