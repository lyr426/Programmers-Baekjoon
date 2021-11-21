class Solution {
    private static long summation(int x, int y){
        long sum =0; 
        for(int i=x; i<=y; i++) sum +=i;
        return sum; 
    }
    public long solution(int a, int b) {
        if(a>b) return summation(b,a);
        return summation(a,b);
    }
}