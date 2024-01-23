package 푸드파이트대회;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<food.length; i++) {
            int num = food[i]/2;
            for(int j=0; j<num; j++) {
                sb.append(String.valueOf(i));
            }
        }
        answer = sb.toString();
        answer += "0";
        answer += sb.reverse().toString();
        return answer;
    }
}