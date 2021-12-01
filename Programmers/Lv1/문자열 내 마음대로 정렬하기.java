import java.util.*; 
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        HashMap<String, Character> map = new HashMap<>();
        for(String s: strings) map.put(s, s.toCharArray()[n]);

        List<Map.Entry<String, Character>> entryList = new ArrayList<Map.Entry<String, Character>>(map.entrySet());

        Collections.sort(entryList, new Comparator<Map.Entry<String, Character>>() {
            @Override
            public int compare(Map.Entry<String, Character> o1, Map.Entry<String, Character> o2) {
                if(o1.getValue() == o2.getValue()) return o1.getKey().compareTo(o2.getKey());
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        int i=0;
        for(Map.Entry<String, Character> entry: entryList)  answer[i++] = entry.getKey();    
        return answer;
    }
}