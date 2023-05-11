package 섬연결하기;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public static void main(String args[]) {
        int len = costs.length;
        int answer = 0;
        boolean[] visit = new boolean[n];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        for(int i=0; i<n; i++){
            if(!visit[i]){
                int min = -1;
                int connect = -1;
                for(int j=0; j<len; j++){
                    if(costs[j][0] == i && (min==-1||costs[j][2]<min)){
                        min = costs[j][2];
                        connect = costs[j][1];
                    }
                    if(costs[j][1] == i && (min==-1||costs[j][2]<min)){
                        min = costs[j][2];
                        connect = costs[j][0];
                    }
                }
                answer += min;
                visit[i] = true;
                visit[connect] = true;
            }
        }
        System.out.println(answer);
    }
}
