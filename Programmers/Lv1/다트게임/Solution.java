package 다트게임;

class Solution {
    private int SDT(int sdt, int num){
        int result = num;
        for(int i=0; i<sdt; i++) result*=num;
        return result;
    }
    public int solution(String dartResult) {
        int answer = 0;
        char[] charArray = dartResult.toCharArray();
        int recentNum = 0;
        for(int i=0; i<charArray.length; i++){
            String sNum ="0";
            while(charArray[i]>='0' && charArray[i]<='9'){
                sNum+=charArray[i++];
            }
            int num = Integer.parseInt(sNum);
            if(charArray[i]=='S') num = SDT(0, num);
            if(charArray[i]=='D') num = SDT(1, num);
            if(charArray[i]=='T') num = SDT(2, num);
            if(i+1 <charArray.length && charArray[i+1]=='*') {
                answer = answer + recentNum + num*2;
                recentNum = num*2;
                i++;
                continue;
            }
            if(i+1 <charArray.length && charArray[i+1]=='#') {
                answer -= num;
                recentNum = num*-1;
                i++;
                continue;
            }
            answer += num;
            recentNum = num;
        }
        return answer;
    }
}