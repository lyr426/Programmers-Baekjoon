package 가장큰수;

import java.util.* ;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        PriorityQueue<String> que = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return (o2+o1).compareTo(o1+o2);
            }
        });

        for(int x : numbers) {
            que.add(String.valueOf(x));
        }
        if(que.peek().equals("0")){
            return "0";
        }
        while(!que.isEmpty()){
            sb.append(que.remove());
        }

        answer = sb.toString();
        return answer;
    }
}