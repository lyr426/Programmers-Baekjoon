package n진수게임;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        StringBuilder answerSb = new StringBuilder();

        int cnt = 0;
        while(sb.length() < m * p * t){
            sb.append(convert(n, cnt));
            cnt += 1;
        }
        cnt = 0;
        while(answerSb.length() < t){
            answerSb.append(sb.charAt(m*cnt+p-1));
            cnt += 1;
        }

        answer = answerSb.toString();
        return answer;
    }

    public String convert(int n, int num){
        StringBuilder sb = new StringBuilder();
        if(num == 0) {
            return "0";
        }
        while(num>0) {
            if(num%n > 9){
                int k = num%n - 10;
                sb.insert(0, (char)('A' + k));
            }else {
                sb.insert(0, String.valueOf(num%n));
            }
            num /= n;
        }
        return sb.toString();
    }
}