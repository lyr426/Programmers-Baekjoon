package 비밀지도;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[][] bi_arr1 = new String[n][n];
        String[][] bi_arr2 = new String[n][n];

        for(int i=0; i<n; i++){
           String str = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr1[i]).toString()));
           bi_arr1[i] = str.split("");
        }
        for(int i=0; i<n; i++){
            String str = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr2[i]).toString()));
            bi_arr2[i] = str.split("");
        }
        for(int i=0; i<n; i++){
            String str ="";
            for(int j=0; j<n; j++){
                int k = Integer.parseInt(bi_arr1[i][j]) + Integer.parseInt(bi_arr2[i][j]);
                if(k==0){
                    str+=" ";
                    continue;
                }
                str+="#";
            }
            answer[i] = str;
        }
        return answer; 
    }
}