import java.util.*;

public class Main {
    
    public static int[] deque = null; 
    public static int size=0; 
    
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine()); 
        deque = new int[N];
        
        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push_front":
                    push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    push_back(Integer.parseInt(st.nextToken()));
                    break;    
                case "pop_front":
                    bw.write(String.valueOf(pop_front())+"\n");
                    break;
                case "pop_back":
                    bw.write(String.valueOf(pop_back())+"\n");
                    break;    
                case "size":
                    bw.write(String.valueOf(size)+"\n");
                    break;
                case "empty":
                    bw.write(String.valueOf(empty())+"\n");
                    break;
                case "front":
                    bw.write(String.valueOf(front())+"\n");
                    break;
                case "back":
                    bw.write(String.valueOf(back())+"\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
    public static int empty(){
        if (size==0) {return 1;}
        else {return 0;}
    }
    public static void push_front(int input){
        for(int i=size-1; i>=0; i--){
            deque[i+1] = deque[i];
        }
        size++;
        deque[0] = input;
    }
    public static void push_back(int input){
        deque[size++] = input; 
    }
    public static int pop_front(){
        if (size==0) {return -1;}
        else {
            int k = deque[0]; 
            for(int i=0; i<size; i++){
                deque[i] = deque[i+1];
            }
            size--; 
            return k;
        }
    }
    public static int pop_back(){
        if(size ==0) {return -1;}
        else{return deque[--size];}
    }
    public static int front(){
        if(size==0){return -1;}
        else {return deque[0];}
    }
    public static int back(){
        if(size==0){return -1;}
        else {return deque[size-1];}
    }
}