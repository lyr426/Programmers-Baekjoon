package 연속된부분수열의합;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int sum = 0;
        int startIdx = 0;
        int length = Integer.MAX_VALUE;
        for(int i=0; i<sequence.length; i++) {
            sum += sequence[i];
            while(k<sum && startIdx < sequence.length-1){
                sum -= sequence[startIdx];
                startIdx += 1;
            }
            if(sum == k && i - startIdx < length){
                answer[0] = startIdx;
                answer[1] = i;
                length = i - startIdx;
            }
        }

        return answer;
    }
}