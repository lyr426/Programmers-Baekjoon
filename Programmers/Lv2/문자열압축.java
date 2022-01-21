import java.util.*; 
class Solution {

    public int solution(String s) {
        int len = s.length();
        int min = len;
        for(int i=1; i<=len/2; i++){
            String[] split = new String[len/i];
            int compression = len;
            int cnt =1;
            for(int j=0; j<len/i; j++){
                split[j] = s.substring(i*j, (i*j)+i);
                if(j>0 &&split[j].equals(split[j-1])){
                    compression -= i;
                    cnt++;
                    if(cnt == 2 || Math.log10(cnt)*10 % 10 == 0) compression+=1;
                    continue;
                }
                cnt = 1;
            }
            min = Math.min(min, compression);
        }
        return min;
    }
}