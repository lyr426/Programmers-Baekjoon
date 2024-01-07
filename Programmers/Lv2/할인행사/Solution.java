package 할인행사;

import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<10; i++){
            map.put(discount[i], map.getOrDefault(discount[i], 0)+1);
        }

        for(int i=0; i<=discount.length-10; i++){
            boolean check = true;
            for(int j=0; j<want.length; j++){
                if(!map.containsKey(want[j]) || map.get(want[j]) < number[j]){
                    check = false;
                    break;
                }
            }
            if(check){
                answer += 1;
            }
            if(discount.length>10+i){
                map.put(discount[i], map.getOrDefault(discount[i], 0) - 1);
                map.put(discount[10+i], map.getOrDefault(discount[10+i], 0) + 1);
            }
        }
        return answer;
    }
}