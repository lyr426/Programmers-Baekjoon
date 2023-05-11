package 소수찾기;

import java.util.*;
class Solution {
    private static boolean prime(int n, ArrayList list){
        for(int i=0; i< list.size(); i++) {
            int num = (int)list.get(i);
            if(Math.sqrt(n) < num) return true;
            if(n%(num) == 0) return false;
        }
        return true;
    }
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=2; i<=n; i++) {
            if(prime(i , list)) {
                list.add(i);
                answer++;
            }
        }
        return answer; 
    }
}