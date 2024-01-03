package k진수에서소수구하기;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.insert(0, String.valueOf(n%k));
            n /= k;
        }
        String[] numbers = sb.toString().split("0");

        for(String num : numbers) {
            if(num.length() == 0) {
                continue;
            }
            if(prime(Long.parseLong(num))){
                answer += 1;
            }
        }


        return answer;
    }

    public boolean prime(Long num){
        if(num < 2) {
            return false;
        }
        for(long i=2; i<=(long)Math.sqrt(num); i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }
}