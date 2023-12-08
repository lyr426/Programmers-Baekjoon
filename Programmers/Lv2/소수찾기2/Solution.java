package 소수찾기2;

import java.util.*;
class Solution {

    public HashMap<Integer, Integer> map = new HashMap<>();

    public int solution(String numbers) {
        int answer = 0;
        int len = numbers.length();
        for(int i=0; i<len; i++){
            boolean[] visit = new boolean[len];
            visit[i] = true;
            String str = numbers.substring(i, i+1);
            bruteforce(numbers, str, visit, 0, len);
        }

        for(int x : map.keySet()){
            System.out.println(x);
            if(prime(x)) answer++;
        }

        return answer;
    }

    public void bruteforce(String numbers, String str, boolean[] visit, int idx, int len){
        if(idx == len) {
            return;
        }
        map.put(Integer.parseInt(str), 0);
        for(int i=0; i<len; i++){
            if(!visit[i]){
                String addStr = str.concat(numbers.substring(i,i+1));
                visit[i] = true;
                bruteforce(numbers, addStr, visit, idx+1, len);
                visit[i] = false;
            }
        }
    }

    public boolean prime(int x){
        if(x < 2) return false;
        for(int i=2; i<=Math.sqrt(x); i++){
            if(x%i == 0) {
                return false;
            }
        }
        return true;
    }
}