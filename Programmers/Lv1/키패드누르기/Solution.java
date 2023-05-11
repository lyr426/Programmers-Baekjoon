package 키패드누르기;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int r = 10, l = 12;
        for(int x: numbers){
            if(x == 1 || x == 4 || x == 7 ){
                answer += 'L';
                continue;
            }
            if(x == 3 || x == 6 || x == 9 ){
                answer += 'R';
                r = x;
                continue;
            }
            if(x == 0) x = 11;
            int lDis = 0, rDis =0;
            lDis = (Math.abs(x - l)/3) + (Math.abs(x - l)%3);
            rDis = (Math.abs(x - r)/3) + (Math.abs(x - r)%3);
            if(lDis == rDis){
                if(hand.equals("right")) lDis++;
                else rDis++; 
            }
            if(lDis > rDis){
                answer += 'R';
                r = x;
                continue;
            }
            answer += 'L';
            l = x;
        }
        return answer;
    }
}