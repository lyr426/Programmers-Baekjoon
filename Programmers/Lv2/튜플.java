import java.util.*; 
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        s = s.replace("{","");
        String[] str = s.split("}");
        int len = str.length;
        answer = new int[len];
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        ArrayList<Integer>[] list = new ArrayList[len];
        for(int i=0; i<len; i++) list[i] = new ArrayList<>();
        for(int i=0; i<len; i++){
            String[] tmp = str[i].split(",");
            for(int j=0; j<tmp.length; j++){
                if(tmp[j].equals("")) continue;
                list[i].add(Integer.parseInt(tmp[j]));
            }
        }

        for(int i=0; i<len; i++) {
            answer[i] = list[i].get(0);
            for (int j = i+1; j < len; j++) {
                list[j].remove(list[j].indexOf(answer[i]));
            }
        }
        return answer; 
    }
}