package 정수제곱근판별;

import java.util.*;
class Solution {
    public long solution(long n) {
        long result = (long)Math.sqrt(n); 
        if(result*result != n ) return -1;
        return (result+1)*(result+1);
    }
}