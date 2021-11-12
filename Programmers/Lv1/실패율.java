class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N]; 
        int[] count = new int[N+1]; 
        double[] fail = new double[N+1]; 
        
        for(int x:stages) count[x-1]++; 
        fail[N] = count[N]; 
        for(int i=N-1; i>=0; i--) fail[i] = count[i] + fail[i+1]; 
        for(int i=0; i<N; i++){
            if(count[i] == 0){
                fail[i] = 0; 
                continue;
            }
            fail[i] = count[i]/fail[i];
        } 

        for(int i=0; i<N; i++){
            double max = -1; 
            int k = 0; 
            for(int j=0; j<N; j++){
                if(fail[j] > max ){
                    max = fail[j];
                    k = j; 
                } 
            }
            fail[k] = -1; 
            answer[i] = k+1; 
        }
        
        return answer;
    }
}