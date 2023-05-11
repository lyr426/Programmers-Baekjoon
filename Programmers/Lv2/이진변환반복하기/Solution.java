package 이진변환반복하기;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0;
        int removeZero = 0;
        int len = s.length();

        while(len>1){
            removeZero += s.length();
            s = s.replace("0", "");
            len = s.length();
            removeZero -= len;
            s = Integer.toBinaryString(len);
            cnt++;
        }
        answer[0] = cnt;
        answer[1] = removeZero;
        return answer; 
    }
}