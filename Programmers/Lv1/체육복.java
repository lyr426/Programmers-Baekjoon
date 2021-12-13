import java.util.*; 
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] cloths = new int[n];
        Arrays.fill(cloths, 1);
        for(int x: lost) cloths[x-1]--; 
        for(int x: reserve) cloths[x-1]++; 
        for(int i=0; i<n; i++){
            if(cloths[i] == 0){
                if(i>0 && cloths[i-1] > 1) answer++; 
                else if(i<n-1 && cloths[i+1] > 1){
                    answer++; 
                    cloths[i+1]--; 
                }
                continue; 
            }
            answer++; 
        }
        
        return answer;
    }
}