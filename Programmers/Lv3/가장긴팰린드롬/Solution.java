package 가장긴팰린드롬;

class Solution
{
    public int solution(String s)
    {
        char[] word = s.toCharArray();
        int len = word.length;
        int max = 1;
        for(int i=1; i<len-1; i++){
            int cnt = 0;
            int j = 1;
            while(i-j >=0 && i+j<len && word[i-j] == word[i+j]){
                cnt++;
                j++;
            }
            if(cnt*2+1 >= max) max = cnt*2+1;
            cnt = 0;
            j = 1;
            while(i-j+1 >=0 && i+j<len && word[i-j+1] == word[i+j]){
                cnt++;
                j++;
            }
            if(cnt*2 >= max) max = cnt*2;
        }
        return max;
    }
}