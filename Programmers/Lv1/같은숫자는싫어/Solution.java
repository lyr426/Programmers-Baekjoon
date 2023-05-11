package 같은숫자는싫어;

public class Solution {
    public int[] solution(int []arr) {
        int cnt=0; 
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] == arr[i+1]){
                arr[i] = -1;
                cnt++; 
            }
        }
        int[] answer = new int[arr.length - cnt]; 
        int num=0; 
        for(int i=0; i<arr.length; i++){
            if(arr[i] != -1){
                answer[num] = arr[i]; 
                num++; 
            }
        }
        
        return answer;
    }
}