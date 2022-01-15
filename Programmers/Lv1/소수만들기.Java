class Solution {
    public boolean check(int n){
        for(int i=2; i<n; i++) if(n%i == 0) return false;
        return true;
    }
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;

        for(int i=0; i<len-2; i++){
            for(int j=i+1; j<len; j++) {
                int sum = nums[i] + nums[j];
                for(int k=j+1; k<len; k++) {
                    if(check(sum+nums[k])) answer++;
                }
            }
        }
        return answer;
    }
}