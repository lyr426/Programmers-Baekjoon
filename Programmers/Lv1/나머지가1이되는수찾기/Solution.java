package 나머지가1이되는수찾기;

class Solution {
    public int solution(int n) {
        int i=1; 
        while(n%i != 1) i++;
        return i; 
    }
}