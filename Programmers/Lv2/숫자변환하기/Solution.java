package 숫자변환하기;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] d = new int[y+1];
        if(x == y) {
            return 0;
        }
        convert(x, y, n, d);
        answer = d[y];
        if(d[y] == 0) {
            answer = -1;
        }

        return answer;
    }

    public void convert(int cur, int y, int n, int d[]) {
        if(cur >= y){
            return;
        }
        int[] numbers = new int[3];
        numbers[0] = cur + n;
        numbers[1] = cur * 2;
        numbers[2] = cur * 3;
        for(int i=0; i<3; i++) {
            if(numbers[i] <= y){
                if(d[numbers[i]] == 0 || d[numbers[i]] > d[cur] + 1) {
                    d[numbers[i]] = d[cur] + 1;
                    convert(numbers[i], y, n, d);
                }
            }
        }

    }
}