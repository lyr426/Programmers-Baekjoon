import java.util.*;

class Number{
    int num;
    int cnt;
    Number(int num, int cnt){
        this.num = num; //고유번호
        this.cnt = cnt; //재생횟수
    }
}

class Swap{
    int x;
    Swap(int x){
        this.x = x;
    }
}

class Solution {
    public static void swap(Swap a, Swap b){
        int tmp = a.x;
        a.x = b.x;
        b.x = tmp;
    }

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, LinkedList<Number>> music = new HashMap<>();
        HashMap<String, Integer> best = new HashMap<>();
        int len = genres.length;
        for(int i=0; i <len; i++){
            if(!music.containsKey(genres[i])){
                music.put(genres[i], new LinkedList<Number>());
            }
            music.get(genres[i]).add(new Number(i, plays[i]));
            best.put(genres[i], best.getOrDefault(genres[i],0)+plays[i]);
        }
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(best.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        LinkedList<Integer> sing = new LinkedList<>();

        for(Map.Entry<String, Integer> entry:entryList){
            Swap max1 = new Swap(-1), max2 = new Swap(-1); // 재생횟수
            Swap max1Num = new Swap(-1), max2Num = new Swap(-1); //고유번호
            if(music.get(entry.getKey()).size() == 1){
                sing.add(music.get(entry.getKey()).get(0).num);
                continue;
            }
            for(Number n: music.get(entry.getKey())){
                if(n.cnt > max2.x){
                    swap(new Swap(n.cnt), max2);
                    swap(new Swap(n.num), max2Num);
                }
                if(max2.x>max1.x){
                    swap(max1, max2);
                    swap(max1Num, max2Num);
                }
            }
            sing.add(max1Num.x);
            sing.add(max2Num.x);
        }
        int[] answer = new int[sing.size()]; 
        for(int i=0; i<answer.length; i++) answer[i] = sing.get(i); 
        return answer;
    }
}