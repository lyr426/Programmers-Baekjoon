import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Integer[] tree = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree, Collections.reverseOrder());
        boolean answer = true;
        for(int i=0; i<N; i++){
            if(tree[i] >= 3){
                tree[i] = tree[i]%3;
            }
            if(tree[i] == 0) continue;
            if(i == N-1){
                if(tree[i] != 0) answer = false;
                continue;
            }
            if(tree[i] == 1){
                if(tree[i+1] >= 2){
                    tree[i+1] -= 2;
                }else {
                    answer = false;
                    break;
                }
            }
            if(tree[i] == 2){
                if(tree[i+1] >= 1){
                    tree[i+1] -= 1;
                }else {
                    answer = false;
                    break;
                }
            }
        }
        if(!answer) bw.write("NO");
        else bw.write("YES");
        bw.flush();
        bw.close();
    }
}
