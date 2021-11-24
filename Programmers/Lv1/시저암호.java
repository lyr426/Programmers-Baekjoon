import java.util.*;
class Solution {
     private static char change(char c, int n){
        char tmp = (char)(c+n);
        if(tmp>='a' && tmp <='z') return tmp;
        return (char)(tmp-26);
    }   
    
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c == ' ') {
                sb.append(" ");
                continue;
            }
            if(c>='A' && c<='Z') {
                sb.append(Character.toUpperCase(change(Character.toLowerCase(c), n)));
                continue;
            }
            sb.append(change(c, n));
        }
        return sb.toString();
    }
}