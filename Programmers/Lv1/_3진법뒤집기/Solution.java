package _3진법뒤집기;

class Solution {
    private int exp(int x){
        int result = 1; 
        for(int i=0; i<x; i++) result *= 3; 
        return result; 
    }
    public int solution(int n) {
        int answer = 0;
        String triple = ""; 
        while(n>0){
            triple += String.valueOf(n%3);
            n/=3; 
        }
        String[] tripleArray = triple.split(""); 
        for(int i=0; i<tripleArray.length; i++){
            int num = Integer.parseInt(tripleArray[tripleArray.length-i-1]);
            answer += num * exp(i);
        }
        return answer;
    }
}