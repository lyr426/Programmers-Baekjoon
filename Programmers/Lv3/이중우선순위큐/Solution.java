package 이중우선순위큐;

import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        Arrays.fill(answer, 0);
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        for(String operation: operations){
            String[] op = operation.split(" ");

            switch(op[0]){
                case "I":
                    maxQueue.add(Integer.parseInt(op[1]));
                    minQueue.add(Integer.parseInt(op[1]));
                    break;
                case "D":
                    if(maxQueue.isEmpty()) {
                        break;
                    }else if (op[1].equals("1")){
                        Integer num = maxQueue.poll();
                        minQueue.remove(num);
                        break;
                    }else {
                        Integer num = minQueue.poll();
                        maxQueue.remove(num);
                        break;
                    }
            }

        }
        if(!maxQueue.isEmpty()){
            answer[0] = maxQueue.peek();
            answer[1] = minQueue.peek();
        }

        return answer;
    }
}