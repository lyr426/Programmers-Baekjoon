class Solution {
    public int solution(String name) {
        int answer = 0;
      char[] nameChar = name.toCharArray();
        int len = nameChar.length;
        int idx=0, cnt =0;
        for(int i=0; i<len; i++){
            if(i>0 &&nameChar[i] == 'A'){
                cnt++;
                if(i==len-1) answer-=cnt;
                if(i+1<len && nameChar[i+1]!='A' && cnt>idx) answer = answer-cnt+idx;
                continue;
            }
            idx = i; cnt =0;
            if(nameChar[i]<='N'){
                answer += (int)nameChar[i]-(int)'A';
                continue;
            }
            answer += (int)'Z' - (int)nameChar[i] +1;
        }
        answer += len-1;
        return answer;
    }
}