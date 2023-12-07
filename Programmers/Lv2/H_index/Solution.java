package H_index;

import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int len = citations.length;
        Arrays.sort(citations);
        for(int i=len; i>=0; i--){
            for(int j=len-1; j>=0; j--){
                if(i>citations[j]){
                    continue;
                }
                if(len - j >= i ){
                    return i;
                }
            }
        }
        return 0;
    }
}