package 로마숫자만들기;
import java.io.*;
import java.util.HashMap;

public class Main {

    static int N;
    static int[] numbers = {1, 5, 10, 50};
    static boolean[] check;
    static int res = 0;
    public static void bruteForce(int len, int sum, int cnt){
        if(cnt == N) {
            if(!check[sum]){
                res += 1;
            }
            check[sum] = true;
            return;
        }
        for(int i=len; i<4; i++){
            bruteForce(i, sum + numbers[i], cnt+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        check = new boolean[50*N+1];
        bruteForce(0, 0, 0);

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();

    }
}
