package 문자열을정수로바꾸기;

class Solution {
    public int solution(String s) {
        if(s.substring(0,1).equals("-")) return Integer.parseInt(s.substring(1,s.length())) * -1;
        else if (s.substring(0,1).equals("+")) return Integer.parseInt(s.substring(1,s.length()));
        else return Integer.parseInt(s.substring(0,s.length()));
    }
}