class Solution {
    public String solution(String number, int k) {
        String answer = "";
        char[] numCharArr = number.toCharArray();
        int len = numCharArr.length; 
        for(int i=0; i<numCharArr.length; i++){
            boolean flag = false;
            for(int j=1; j<=k; j++){
                if(i+j >= len) return answer; 
                if(numCharArr[i] < numCharArr[i+j]){
                    k--;
                    flag = true;
                    break;
                }
            }
            if(!flag) answer += numCharArr[i];
        }
        
        return answer;
    }
}