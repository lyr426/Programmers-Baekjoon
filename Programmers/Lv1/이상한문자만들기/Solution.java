package 이상한문자만들기;

class Solution {
    public String solution(String s) {
        String answer = "";
        s+=" /";
        for(String str: s.split(" ")){
            if(str.equals("/")) break;
            String[] arr = str.split("");
            for(int i=0; i<arr.length; i++){
                if(i%2 == 0) {
                    answer += (arr[i].toUpperCase());
                    continue;
                }
                answer += (arr[i].toLowerCase());
            }
            answer += " ";
        }
        answer = answer.substring(0,answer.length()-1);
        return answer; 
    }
}