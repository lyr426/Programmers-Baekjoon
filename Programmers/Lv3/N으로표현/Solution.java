package N으로표현;

import java.util.*;
class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        HashSet<Integer>[] lists = new HashSet[8];
        for(int i=0; i<8; i++) {
            lists[i] = new HashSet<>();
            int cnt = N;
            for(int j=0; j<i; j++) {
                cnt *= 10;
                cnt += N;
            }
            lists[i].add(cnt);
            if(cnt == number) {
                return i + 1;
            }
        }

        for(int i=1; i<8; i++) { // i = 5
            for(int j=0; j<i; j++){ // j = 0 ~ 4 : 0 + 4, 1 + 3, 2 + 2 //// j, i-j
                List<Integer> list1= new ArrayList<>(lists[j]);
                List<Integer> list2= new ArrayList<>(lists[i-j-1]);

                for(int x : list1) {
                    for(int y: list2) {
                        lists[i].add(x + y);
                        lists[i].add(x * y);
                        lists[i].add(x - y);
                        if(y > 0) {
                            lists[i].add(x / y);
                        }
                    }
                }
            }
            if(lists[i].contains(number)) {
                return i+1;
            }
        }

        return answer;
    }
}