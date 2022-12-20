package 대표자연수;

import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int represent = 0;
        int min = -1;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            int sum = 0;
            for(int j=0; j<N; j++) sum += Math.abs(arr[i]-arr[j]);
            if(min == -1 || min > sum || (min == sum && represent > arr[i])){
                min = sum;
                represent = arr[i];
            }
        }
        bw.write(String.valueOf(represent));
        bw.flush();
        bw.close();
    }
}