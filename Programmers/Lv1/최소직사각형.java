import java.util.*; 
class Solution {
    public int solution(int[][] sizes) {
        int max_hor = 0, max_ver = 0; 
        
        for(int i=0; i<sizes.length; i++){
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);
            if(max_hor<max) max_hor = max; 
            if(max_ver<min) max_ver = min; 
        }
        
        return max_hor*max_ver;
    }
}