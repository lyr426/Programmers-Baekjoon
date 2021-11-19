import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String args[]) {
        String s = "one4seveneight";
        StringBuilder sb = new StringBuilder();
        String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        HashMap<String, Integer> num = new HashMap<>();
        for(int i=0; i<10; i++) num.put(number[i], i);

        int[] lengthOfNumber = {3,4,5};
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
                for(int j=0; j<3; j++){
                    if(num.containsKey(s.substring(i,i+lengthOfNumber[j]))){
                        sb.append(num.get(s.substring(i,i+lengthOfNumber[j])));
                        i = i + lengthOfNumber[j] - 1;
                        break;
                    }
                }
                continue;
            }
            sb.append(s.charAt(i));
        }
        System.out.println(Integer.parseInt(sb.toString()));


    }
}

