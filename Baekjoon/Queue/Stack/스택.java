import java.util.*;

public class Main {
    
    public static int[] arr = null; 
    public static int size=0;

    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine()); 
        arr = new int[N];
        
        while (N-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String com = st.nextToken();
            
            switch(com){
                case "push": 
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    bw.write(String.valueOf(pop()) + "\n"); 
                    break;
                case "size":
                    bw.write(String.valueOf(size) + "\n"); 
                    break;
                case "top":
                    bw.write(String.valueOf(top()) + "\n");
                    break;
                case "empty":
                    bw.write(String.valueOf(empty()) + "\n");
                    break;       
            }
        }
        bw.flush();
        bw.close();   
    }
    public static int empty(){
        if(size == 0){return 1;}
        else {return 0;}
    }
    public static void push(int X){
        arr[size] = X;
        size++; 
    }
    public static int pop(){
        if(empty()==1){return -1;}
        else {
            size--;
            return arr[size];
        }
    }
    public static int top(){
        if(empty() ==1){return -1;}
        else{
            return arr[size-1];
        }
    }

}