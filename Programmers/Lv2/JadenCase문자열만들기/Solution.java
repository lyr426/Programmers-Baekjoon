package JadenCase문자열만들기;

class Solution {
    private static String jadenCase(String str){
        char[] output = new char[str.length()];
        
        int i=-1;
        for(char c: str.toCharArray()){
            i++;
            if(i==0 && (c >='a' && c<='z')) {
                output[i] = Character.toUpperCase(c);
                continue;
            }
            if(i!=0 && c >= 'A' && c <= 'Z'){
                output[i] = Character.toLowerCase(c);
                continue;
            }
            output[i] = c;
        }
        return String.valueOf(output);
    }
    public String solution(String s) {
        String[] jaden = s.split(" ");
        if(s.substring(s.length() - 1, s.length()).equals(" ")) {
            jaden[jaden.length-1] += " ";
        }        
        StringBuilder sb = new StringBuilder();

        for(String str: jaden){
            sb.append(jadenCase(str)+" ");
        }
        
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}