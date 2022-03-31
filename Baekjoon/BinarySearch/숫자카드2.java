import java.util.*;
import java.io.*;

public class Main {

    private static int lowerBound(int[] arr, int x){
        int left = 0, right = arr.length, mid = 0;
        while(left < right){
            mid = (left+right)/2;
            if(arr[mid]>=x) right = mid;
            else left = mid+1;
        }
        return left;
    }
    private static int upperBound(int[] arr, int x){
        int left = 0, right = arr.length, mid = 0;
        while(left < right){
            mid = (left+right)/2;
            if(arr[mid]>x) right = mid;
            else left = mid+1;
        }
        return left;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<M; i++) {
            int target = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(upperBound(arr,target)-lowerBound(arr,target))+" ");
        }
        bw.flush();
    }
}
