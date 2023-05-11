package 제일작은수제거하기;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {-1};
        if(arr.length == 1) return answer; 
        answer = new int[arr.length-1];
        int min = arr[0]; 
        for(int x:arr){
            if(x < min) min = x; 
        }
        int i=0;
        for(int x:arr) if(x != min)answer[i++] = x; 

        return answer;
    }
}
