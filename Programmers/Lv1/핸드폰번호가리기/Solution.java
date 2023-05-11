package 핸드폰번호가리기;

class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int len = phone_number.length(); 
        
        answer = phone_number.substring(len-4, len);
        answer = String.format("%"+len+"s", answer).replace(' ', '*'); 
        
        
        return answer;
    }
}