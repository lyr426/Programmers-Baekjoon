class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right-left+1);
        int[] answer = new int[size];
        int i = (int)(left / n);
        int j = (int)(left % n);
        for(int k=0; k<size; k++){
            if(j>=n) {
                i++;
                j = 0;
            }
            answer[k] = Math.max(i,j)+1;
            j++; 
        }
        return answer;
    }
}