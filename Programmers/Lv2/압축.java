import java.util.*;
class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> dictionary = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int num = 0;
        for(num=1; num<=26; num++){
            char c = (char)('A'+num-1);
            dictionary.put(String.valueOf(c), num);
        } //A~Z 사전에 저장
        char[] word = msg.toCharArray();
        for(int i=0; i<msg.length(); i++){
            String check = String.valueOf(word[i]);
            int n=1;
            while(i+n < msg.length() && dictionary.containsKey(check)){
                check += String.valueOf(word[i+n]);
                n++;
            }
            if(dictionary.containsKey(check)){
                result.add(dictionary.get(check));
                break;
            }
            dictionary.put(check, num++);
            String str = check.substring(0,check.length()-1);
            if(n>=3) i+=n-2;
            result.add(dictionary.get(str));
        }
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++) answer[i] = result.get(i);
        return answer;
    }
}