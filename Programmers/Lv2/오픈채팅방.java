import java.util.*; 
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        int len = record.length;
        HashMap<String, String> name = new HashMap<>();
        String[][] str = new String[len][3];
        int change_cnt=0;
        for(int i=0; i< len; i++) {
            str[i] = record[i].split(" ");
            if(str[i][0].equals("Enter")) name.put(str[i][1], str[i][2]);
            if(str[i][0].equals("Change")) {
                name.replace(str[i][1], str[i][2]);
                change_cnt++;
            }
        }
        answer = new String[len-change_cnt];
        int answer_cnt = 0;
        for(int i=0; i<len; i++){
            if(str[i][0].equals("Enter")){
                String nickname = name.get(str[i][1]);
                answer[answer_cnt] = nickname+"님이 들어왔습니다.";
                answer_cnt++;
                continue;
            }
            if(str[i][0].equals("Leave")){
                String nickname = name.get(str[i][1]);
                answer[answer_cnt] = nickname+"님이 나갔습니다.";
                answer_cnt++;
            }
        }
        return answer;
    }
}