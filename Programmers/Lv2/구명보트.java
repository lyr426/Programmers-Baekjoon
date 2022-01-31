import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String args[]) {

        int[] people = {70,50,80,50};
        int limit = 100;
        int answer = 0;
        ArrayList<Integer> weight
                = (ArrayList<Integer>) Arrays.stream(people)
                    .boxed()
                    .collect(Collectors.toList());
        Collections.sort(weight, Collections.reverseOrder());

        while (!weight.isEmpty()){
            int sum = weight.remove(0);
            while(!weight.isEmpty() && sum + weight.get(weight.size()-1) <= limit ){
                sum += weight.remove(weight.size()-1);
            }
            answer+=1;
        }
        System.out.println(answer);

    }

}
