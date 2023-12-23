package 주차요금계산하기;

import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        int len = records.length;
        List<String[]> inRecords = new ArrayList<>();
        List<String[]> outRecords = new ArrayList<>();

        for(int i=0; i<len; i++) {
            String[] str = records[i].split(" ");
            if(str[2].equals("IN")) {
                inRecords.add(str);
            }else {
                outRecords.add(str);
            }
        }
        // Collections.sort(inRecords, Comparator.comparing((String[] o)-> o[1]));
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<inRecords.size(); i++) {
            String[] in = inRecords.get(i);
            String[] inTime = in[0].split(":");
            int inHour = Integer.parseInt(inTime[0]);
            int inMin = Integer.parseInt(inTime[1]);
            int outHour = -1;
            int outMin = -1;
            for(int j=0; j<outRecords.size(); j++) {
                String[] out = outRecords.get(j);
                if(!out[1].equals(in[1])){
                    continue;
                }
                String[] time = out[0].split(":");
                outHour = Integer.parseInt(time[0]);
                outMin = Integer.parseInt(time[1]);
                outRecords.remove(j);
                break;
            }
            if(outHour == -1) {
                outHour = 23;
                outMin = 59;
            }
            int totalMin = (outHour * 60 + outMin) - (inHour*60 + inMin);
            map.put(in[1], map.getOrDefault(in[1], 0) + totalMin);
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        int i = 0;
        answer = new int[list.size()];
        int upper = fees[2]-1;
        for(String num : list) {
            int min = map.get(num);
            int fee = fees[1];
            if(min > fees[0]){
                fee += ((min - fees[0] + upper)/fees[2]) * fees[3];
            }
            answer[i] = fee;
            i += 1;
        }

        return answer;
    }
}