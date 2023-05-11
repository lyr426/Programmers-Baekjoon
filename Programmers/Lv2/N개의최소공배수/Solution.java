package N개의최소공배수;

import java.util.*;
class Solution {
    public boolean check(int[] arr, int n){
        for(int i=0; i<arr.length; i++) if(n%arr[i] != 0) return false;
        return true;
    }
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int mul = 1;
        while (!check(arr, mul*arr[0])){
            mul++;
        }
        return mul*arr[0]; 
    }
}