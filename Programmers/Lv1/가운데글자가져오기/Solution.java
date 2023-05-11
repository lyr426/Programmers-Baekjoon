package 가운데글자가져오기;

class Solution {
    public String solution(String s) {
        int len = s.length(); 
        if(len%2 == 0) return s.substring(len/2-1, len/2+1);
        return s.substring(len/2, len/2+1); 
    }
}