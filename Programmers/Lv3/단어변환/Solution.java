package 단어변환;

class Solution {
    private static boolean check(char[] c1, char[] c2){
        int cnt =0;
        for(int i=0; i<c1.length; i++){
            if(c1[i] != c2[i]) cnt++;
            if(cnt >=2 )return false;
        }
        if(cnt==1) return true;
        return false;
    }
    private static void dfs(String cur, String target, String[] words, int[] visit, int cnt){
        if(cur.equals(target)) return;
        for(int i=0; i<words.length; i++){
            if((visit[i]==0 || visit[i] > cnt )&& check(cur.toCharArray(), words[i].toCharArray())){
                visit[i] = cnt;
                dfs(words[i], target, words, visit, cnt+1);
            }
        }
    }
    public int solution(String begin, String target, String[] words) {
        int visit[] =new int[words.length];
        dfs(begin, target, words,visit, 1);

        for(int i=0; i< words.length; i++){
             if(words[i].equals(target)) return visit[i];
        }
        return 0;
    }
}