import java.util.*;
class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        HashMap<String, Integer> num = new HashMap<>();
        for(int i=0; i<10; i++) num.put(number[i], i);

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
                if(num.containsKey(s.substring(i,i+3))){
                    sb.append(num.get(s.substring(i,i+3)));
                    i+=2;
                    continue;
                }
                if(num.containsKey(s.substring(i,i+4))){
                    sb.append(num.get(s.substring(i,i+4)));
                    i+=3;
                    continue;
                }
                if(num.containsKey(s.substring(i,i+5))){
                    sb.append(num.get(s.substring(i,i+5)));
                    i+=4;
                    continue;
                }
                continue;
            }
            sb.append(s.charAt(i));
        }
        return Integer.parseInt(sb.toString()); 
    }
}