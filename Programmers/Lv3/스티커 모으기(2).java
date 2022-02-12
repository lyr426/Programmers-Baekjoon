class Solution {
    public int solution(int sticker[]) {
        int len = sticker.length;
        int[][] d1 = new int[len][2]; // 첫번째 뜯는 경우
        int[][] d2 = new int[len][2]; // 첫번째 안 뜯는 경우
        
        if(len == 1) return sticker[0];

        d1[0][0] = sticker[0];
        d1[1][0] = sticker[1];
        d1[1][1] = sticker[0];
        d2[1][0] = sticker[1];

        for(int i=2; i<len; i++){
            d1[i][0] = d1[i-1][1] + sticker[i];
            d1[i][1] = Math.max(d1[i-1][0], d1[i-1][1]);

            d2[i][0] = d2[i-1][1] + sticker[i];
            d2[i][1] = Math.max(d2[i-1][0], d2[i-1][1]);
        }
        return Math.max(d1[len-1][1], d2[len-1][0]);
    }
}