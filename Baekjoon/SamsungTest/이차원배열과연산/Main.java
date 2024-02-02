package 이차원배열과연산;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class Main {


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());



        int[][] A = new int[101][101];
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<3; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = -1;
        int col = 3;
        int row = 3;

        for(int i=0; i<102; i++){
            if(A[r-1][c-1] == k) {
                result = i;
                break;
            }
            if(row >= col){
                col = RowOperation(row, col, A);
            } else {
                row = ColOperations(row, col, A);
            }
//            for(int m=0; m<row; m++){
//                for(int j=0; j<col; j++){
//                    System.out.print(A[m][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }

        System.out.println(result);


        //R의 경우


    }

    private static int ColOperations(int row, int col, int[][] A) {
        HashMap<Integer, Integer> countNum;
        int maxRow = -1;
        for(int i=0; i<col; i++){
            countNum = new HashMap<>();
            for(int j=0; j<row; j++){
                if(A[j][i] == 0) continue;
                countNum.put(A[j][i], countNum.getOrDefault(A[j][i], 0)+1);
            }
            int num = 0;
            List<Map.Entry<Integer, Integer>> list = new LinkedList<>(countNum.entrySet());
            Collections.sort(list, (o1, o2) -> {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o1.getValue().compareTo(o2.getValue());
            });
            for(Map.Entry<Integer, Integer> entry : list){
                A[num][i] = entry.getKey();
                A[num+1][i] = entry.getValue();
                num += 2;
                if(num >= 100) break;
            }
            if(num >= maxRow) {
                maxRow = num;
            }
            if(row > num){
                while (num <= row){
                    A[num][i] = 0;
                    num++;
                }
            }
        }
        return maxRow;
    }

    private static int RowOperation(int row, int col, int[][] A) {
        HashMap<Integer, Integer> countNum;
        int maxCol = -1;
        for(int i=0; i<row; i++){
            countNum = new HashMap<>();
            for(int j=0; j<col; j++){
                if(A[i][j] == 0) continue;
                countNum.put(A[i][j], countNum.getOrDefault(A[i][j], 0)+1);
            }
            int num = 0;
            List<Map.Entry<Integer, Integer>> list = new LinkedList<>(countNum.entrySet());
            Collections.sort(list, (o1, o2) -> {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o1.getValue().compareTo(o2.getValue());
            });
            for(Map.Entry<Integer, Integer> entry : list){
                A[i][num] = entry.getKey();
                A[i][num+1] = entry.getValue();
                num += 2;
                if(num >= 100) break;
            }
            if(num >= maxCol) {
                maxCol = num;
            }
            if(row > num){
                while (num <= row){
                    A[i][num] = 0;
                    num++;
                }
            }
        }
        return maxCol;
    }
}
