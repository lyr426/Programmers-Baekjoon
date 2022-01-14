import java.util.*;
class Solution {
    public int MUL = 65536; 
    public boolean check(String str){
        for(char c:str.toCharArray()) if(c>'z' || c<'a') return false;
        return true;
    }
    public void listAdd(String str, ArrayList list){
        for(int i=0; i<str.length()-1; i++){
            String str_tmp = str.substring(i,i+2);
            if(check(str_tmp)) list.add(str_tmp);
        }
    }
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase(Locale.ROOT);
        str2 = str2.toLowerCase(Locale.ROOT);

        ArrayList<String> str1_arr = new ArrayList<>();
        ArrayList<String> str2_arr = new ArrayList<>();

        listAdd(str1, str1_arr);
        listAdd(str2, str2_arr);

        int N = str1_arr.size() + str2_arr.size();
        if(N==0) return MUL; 
        int inter = 0;
        for(int i=0; i<str1_arr.size(); i++){
            String str = str1_arr.get(i);
            if(str2_arr.contains(str)){
                str2_arr.remove(str2_arr.indexOf(str));
                inter++;
            }
        }
        int answer = (int)(inter/(double)(N-inter)*MUL);
        return answer;
    }
}