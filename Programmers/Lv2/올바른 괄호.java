class Solution {
    boolean solution(String s) {
        int cnt=0; 
        for(char c: s.toCharArray()){
            if(c == '(') {
                cnt++;
                continue;
            }
            if(cnt<=0) return false;
            cnt--; 
        }
        if(cnt == 0) return true;
        return false;
    }
}