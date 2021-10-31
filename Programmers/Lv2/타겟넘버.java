class Solution {
    private int dfs(int[] numbers, int target, int cur, int sum){
        if(cur == numbers.length) {
            if(sum == target) return 1;
            return 0;
        }
        return dfs(numbers, target, cur+1, sum+numbers[cur]) + dfs(numbers, target, cur+1, sum-numbers[cur]); 
    }
    
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0); 
    }
}