import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Stack<Integer> stack = new Stack<>(); 
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> result = new Stack<>(); 
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for(int i=0; i<N; i++){
            stack.push(Integer.parseInt(st.nextToken())); 
        }
        
        for(int i=0; i<N ; i++){
            int k = stack.pop(); 
            while(!stack2.empty() && stack2.peek() <= k ){
                stack2.pop(); 
            }
            if (stack2.empty()){
                result.add(-1);
                stack2.push(k);  
            }
            else{
                result.add(stack2.peek());
                stack2.push(k); 
            }
        }
        while(!result.empty()){
            bw.write(String.valueOf(result.pop()));
            if(!result.empty()){bw.write(" ");}
        }
        
        bw.flush();
        bw.close(); 
    }
}