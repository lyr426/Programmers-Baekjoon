package 균형잡힌세상;

import java.util.*;
import java.io.*; 

public class Main {
    
    
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        while(true){
            String str = br.readLine();
            boolean flag = true; 
            Stack<String> stack = new Stack<>(); 
            if(str.equals("."))break; 
            String[] bracket = str.split("");
            int num = str.length(); 
            for(int i =0; i<num; i++){
                if(bracket[i].equals("(")){stack.push(bracket[i]);}
                else if(bracket[i].equals("[")){stack.push(bracket[i]);}
                else if(bracket[i].equals(")")){
                    if (stack.empty() || !stack.peek().equals("(")){
                        flag = false; 
                        break;   
                    }
                    stack.pop(); 
                }
                else if(bracket[i].equals("]")){
                     if (stack.empty() || !stack.peek().equals("[")){
                        flag = false; 
                        break;   
                    }
                    stack.pop(); 
                }
            }
            if(stack.empty() && flag == true ){ bw.write("yes\n"); }
            else {bw.write("no\n"); }
        }
        
        bw.flush();
        bw.close();
    }
}