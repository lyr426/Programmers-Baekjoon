package 조이스틱;

class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] nameArr = name.toCharArray();
        int len = name.length();
        int minRoute = len - 1;
        for(int i=0; i<len; i++){
            int num = Math.min((int)(nameArr[i]-'A'), (int)('Z' - nameArr[i] + 1));
            int idx = i + 1;
            while(idx < len && nameArr[idx] == 'A') {
                idx += 1;
            }
            minRoute = Math.min(minRoute, i*2 + len - idx);
            minRoute = Math.min(minRoute, (len-idx)*2 + i);
            answer += num;
        }
        answer += minRoute;
        return answer;
    }
}