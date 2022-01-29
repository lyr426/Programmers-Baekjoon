import java.util.*;
class Solution {
    public boolean check(String str){
        Stack<Character> stack = new Stack<>();
        for(char c: str.toCharArray()){
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if(c==')'){
                if(!stack.isEmpty() && stack.peek()=='(') stack.pop();
                else return false;
                continue;
            }
            if(c==']'){
                if(!stack.isEmpty() && stack.peek()=='[') stack.pop();
                else return false;
                continue;
            }
            if(c=='}'){
                if(!stack.isEmpty() && stack.peek()=='{') stack.pop();
                else return false;
                continue;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
    public String queToString(String str){
        str = str.replaceAll(" ", "");
        str = str.replace(",","");
        return str.substring(1,str.length()-1);
    }
    public int solution(String s) {
        int answer = 0;

        Deque<Character> bracket = new ArrayDeque<>();
        for(char c: s.toCharArray()) bracket.add(c);
        for(int i=0; i<s.length(); i++){
            if(check(queToString(bracket.toString()))) answer++;
            bracket.add(bracket.removeFirst());
        }
        return answer;
    }
}