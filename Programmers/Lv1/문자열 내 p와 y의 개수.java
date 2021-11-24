import java.util.*; 
class Solution {
    boolean solution(String s) {
        int pnum =0, ynum=0;
        for(char c: s.toCharArray()){
            if(c == 'p' || c == 'P') pnum++;
            if(c == 'y' || c == 'Y') ynum++; 
        }
        if(pnum == ynum) return true; 
        return false; 
    }
}