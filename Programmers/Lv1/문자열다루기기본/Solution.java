package 문자열다루기기본;

import java.io.IOException;
class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length() != 4 && s.length() != 6) return false;  
        try{
            int a = Integer.parseInt(s); 
        }
        catch(NumberFormatException e){
            return false; 
        }
        
        return answer;
    }
}