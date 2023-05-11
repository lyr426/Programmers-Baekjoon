package 신고결과받기;

import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int len = id_list.length;
        int[] answer = new int[len];
        ArrayList<String>[] member =  new ArrayList[len];
        ArrayList<String> list = new ArrayList<>();
        for(String s: id_list) list.add(s);
        for(int i=0; i<len; i++) member[i] = new ArrayList<String>();
        for(String s: report){
            String[] result = s.split(" ");
            if(!member[list.indexOf(result[1])].contains(result[0])) {
                member[list.indexOf(result[1])].add(result[0]);
            }
        }
        for(ArrayList list1: member){
            if(list1.size()>=k){
                for (Object s: list1) answer[list.indexOf(s)] += 1;
            }
        }
        return answer;
    }
}