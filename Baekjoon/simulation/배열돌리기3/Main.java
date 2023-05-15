package simulation.배열돌리기3;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        int[][] result = arr;
        for(int i=0; i<R; i++) {
            result = swap(result, Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i< result.length; i++) {
            for(int j=0; j< result[0].length; j++){
                bw.write(String.valueOf(result[i][j])+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static int[][] swap(int[][] inputArr, int R) {
        int N = inputArr.length;
        int M = inputArr[0].length;
        int[][] nmArr = new int[N][M];
        int[][] mnArr = new int[M][N];

        switch (R) {
            case 1 : {
                for(int i=0; i<N; i++) {
                    for(int j=0; j<M; j++) {
                        nmArr[i][j] = inputArr[N-i-1][j];
                    }
                }
                return nmArr;
            }
            case 2 : {
                for(int i=0; i<N; i++) {
                    for(int j=0; j<M; j++) {
                        nmArr[i][j] = inputArr[i][M-j-1];
                    }
                }
                return nmArr;
            }
            case 3 : {
                for(int i=0; i<M; i++) {
                    for(int j=0; j<N; j++) {
                        mnArr[i][j] = inputArr[N-j-1][i];
                    }
                }
                return mnArr;
            }
            case 4 : {
                for(int i=0; i<M; i++) {
                    for(int j=0; j<N; j++) {
                        mnArr[i][j] = inputArr[j][M-i-1];
                    }
                }
                return mnArr;
            }
            case 5 : {
                for(int i=0; i<N; i++) {
                    for(int j=0; j<M; j++) {
                        int x = i < N/2 ? ( j < M/2 ? i : i + N/2) : (j < M/2 ? i-(N/2) : i);
                        int y = i < N/2 ? ( j < M/2 ? j + M/2 : j) : (j < M/2 ? j : j-(M/2));
                       nmArr[x][y] = inputArr[i][j];
                    }
                }
                return nmArr;
            }
            case 6 : {
                for(int i=0; i<N; i++) {
                    for(int j=0; j<M; j++) {
                        int x = i < N/2 ? ( j < M/2 ? i + (N/2) : i) : (j < M/2 ? i : i-(N/2));
                        int y = i < N/2 ? ( j < M/2 ? j : j - (M/2)) : (j < M/2 ? j+(M/2): j);
                        nmArr[x][y] = inputArr[i][j];
                    }
                }
                return nmArr;
            }
            default: return inputArr;
        }

    }
}
