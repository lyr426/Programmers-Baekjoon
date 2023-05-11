package 전화번호목록;

import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
       HashMap<String, Integer> hash = new HashMap<>();
       HashMap<Integer, Integer> len = new HashMap<>();
       Arrays.sort(phone_book);
       for(String str: phone_book){
           for(int i: len.keySet()){
               if(str.length()>i && hash.containsKey(str.substring(0,i))){
                   return false; 
               }
           }
           hash.put(str, 0);
           len.put(str.length(),0); 
       }
    return true;
    }
}