import java.util.*; 
class Solution {
    public long solution(long n) {
        int len = (int)(Math.log10(n)+1); 
        Integer[] arr = new Integer[len]; 
        for(int i=0; i<len; i++) {
            arr[i] = (int)(n%10); 
            n/=10; 
        }
        Arrays.sort(arr, Collections.reverseOrder()); 
        String str = Arrays.toString(arr).replaceAll("[^0-9]",""); 
        return Long.parseLong(str);  
    }
}