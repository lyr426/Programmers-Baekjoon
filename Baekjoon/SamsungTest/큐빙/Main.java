package 큐빙;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static HashMap<Character, Integer[]> cubeNumber;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        cubeNumber = new HashMap<>(){{
            put('U', new Integer[]{2, 4, 3, 5, 0});
            put('D', new Integer[]{2, 5, 3, 4, 2});
            put('F', new Integer[]{0, 5, 1, 4});
            put('B', new Integer[]{0, 4, 1, 5});
            put('L', new Integer[]{0, 2, 1, 3, 0});
            put('R', new Integer[]{2, 0, 3, 1, 2});
        }};

        for(int i=0; i<N; i++) {
            int K = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            char[][][] cube = makeCube();
            while(st.hasMoreTokens()) {
                char[] operation = st.nextToken().toCharArray();
                move(cube, operation);
            }
            printCube(cube[0]);

//            for(int p=0; p<6; p++){
//                System.out.println("p==" + p + "===============");
//                for(int q=0; q<3; q++){
//                    for(int r=0; r<3; r++) {
//                        System.out.print(cube[p][q][r]);
//                    }
//                    System.out.println();
//                }
//                System.out.println();
//            }


        }
    }

    private static char[][][] makeCube() {
        char[][][] cube = {{{'w', 'w', 'w'}, {'w', 'w', 'w'}, {'w', 'w', 'w'}},
                {{'y', 'y', 'y'}, {'y', 'y', 'y'}, {'y', 'y', 'y'}},
                {{'r', 'r', 'r'}, {'r', 'r', 'r'}, {'r', 'r', 'r'}},
                {{'o', 'o', 'o'}, {'o', 'o', 'o'}, {'o', 'o', 'o'}},
                {{'g', 'g', 'g'}, {'g', 'g', 'g'}, {'g', 'g', 'g'}},
                {{'b', 'b', 'b'}, {'b', 'b', 'b'}, {'b', 'b', 'b'}} };
        return cube;
    }

    private static void printCube(char[][] chars) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<chars.length; i++) {
            for(int j=0; j<chars[0].length; j++) {
                bw.write(String.valueOf(chars[i][j]));
            }
            bw.write("\n");
        }
        bw.flush();
    }

    private static void move(char[][][] cube, char[] operation) {
        if(operation[0] == 'U' || operation[0] == 'D') {
            Integer[] arr = cubeNumber.get(operation[0]);
            if(operation[1] == '+') {
                char[] tmp = cube[arr[3]][arr[4]].clone();
                for(int i=3; i>0; i--) {
                    cube[arr[i]][arr[4]] = cube[arr[i-1]][arr[4]];
                }
                cube[arr[0]][arr[4]] = tmp.clone();
                return;
            }
            char[] tmp = cube[arr[0]][arr[4]].clone();
            for(int i=0; i<3; i++) {
                cube[arr[i]][arr[4]] = cube[arr[i+1]][arr[4]].clone();
            }
            cube[arr[3]][arr[4]] = tmp.clone();
            return;
        }
        if(operation[0] == 'R' || operation[0] == 'L') {
            Integer[] arr = cubeNumber.get(operation[0]);
            if(operation[1] == '+') {
                char[] tmp = new char[]{cube[arr[3]][0][arr[4]],cube[arr[3]][1][arr[4]], cube[arr[3]][2][arr[4]]};
                for(int i=3; i>0; i--) {
                    cube[arr[i]][0][arr[4]] = cube[arr[i-1]][0][arr[4]];
                    cube[arr[i]][1][arr[4]] = cube[arr[i-1]][1][arr[4]];
                    cube[arr[i]][2][arr[4]] = cube[arr[i-1]][2][arr[4]];
                }
                cube[arr[0]][0][arr[4]] = tmp[0];
                cube[arr[0]][1][arr[4]] = tmp[1];
                cube[arr[0]][2][arr[4]] = tmp[2];
                return;
            }
            char[] tmp = new char[]{cube[arr[0]][0][arr[4]],cube[arr[0]][1][arr[4]], cube[arr[0]][2][arr[4]]};
            for(int i=0; i<3; i++) {
                cube[arr[i]][0][arr[4]] = cube[arr[i+1]][0][arr[4]];
                cube[arr[i]][1][arr[4]] = cube[arr[i+1]][1][arr[4]];
                cube[arr[i]][2][arr[4]] = cube[arr[i+1]][2][arr[4]];
            }
            cube[arr[3]][0][arr[4]] = tmp[0];
            cube[arr[3]][1][arr[4]] = tmp[1];
            cube[arr[3]][2][arr[4]] = tmp[2];
            return;
        }
        if(operation[0] == 'F') {
            Integer[] arr = cubeNumber.get(operation[0]);
            if(operation[1] == '+') {
                char[] tmp = new char[]{cube[arr[3]][0][2], cube[arr[3]][1][2], cube[arr[3]][2][2]};
                cube[arr[3]][0][2] = cube[arr[2]][2][0];
                cube[arr[3]][1][2] = cube[arr[2]][2][1];
                cube[arr[3]][2][2] = cube[arr[2]][2][2];
                cube[arr[2]][2] = new char[]{cube[arr[1]][0][2],cube[arr[1]][1][2],cube[arr[1]][2][2]};
                cube[arr[1]][0][0] = cube[arr[0]][2][0];
                cube[arr[1]][1][0] = cube[arr[0]][2][1];
                cube[arr[1]][2][0] = cube[arr[0]][2][2];
                cube[arr[0]][2] = tmp.clone();
                return;
            }
            char[] tmp = cube[arr[0]][2].clone();
            cube[arr[0]][2] = new char[]{cube[arr[1]][0][2],cube[arr[1]][1][2],cube[arr[1]][2][2]};
            cube[arr[1]][0][0] = cube[arr[2]][2][0];
            cube[arr[1]][1][0] = cube[arr[2]][2][1];
            cube[arr[1]][2][0] = cube[arr[2]][2][2];
            cube[arr[2]][2] = new char[]{cube[arr[3]][0][2],cube[arr[3]][1][2],cube[arr[3]][2][2]};
            cube[arr[3]][0][2] = tmp[0];
            cube[arr[3]][1][2] = tmp[1];
            cube[arr[3]][2][2] = tmp[2];
            return;
        }

        if(operation[0] == 'B') {
            Integer[] arr = cubeNumber.get(operation[0]);
            if(operation[1] == '+') {
                char[] tmp = new char[]{cube[arr[3]][0][2], cube[arr[3]][1][2], cube[arr[3]][2][2]};
                cube[arr[3]][0][2] = cube[arr[2]][0][0];
                cube[arr[3]][1][2] = cube[arr[2]][0][1];
                cube[arr[3]][2][2] = cube[arr[2]][0][2];
                cube[arr[2]][0] = new char[]{cube[arr[1]][0][2],cube[arr[1]][1][2],cube[arr[1]][2][2]};
                cube[arr[1]][0][0] = cube[arr[0]][0][0];
                cube[arr[1]][1][0] = cube[arr[0]][0][1];
                cube[arr[1]][2][0] = cube[arr[0]][0][2];
                cube[arr[0]][0] = tmp.clone();
                return;
            }
            char[] tmp = cube[arr[0]][2].clone();
            cube[arr[0]][2] = new char[]{cube[arr[1]][0][2],cube[arr[1]][1][2],cube[arr[1]][2][2]};
            cube[arr[1]][0][0] = cube[arr[2]][0][0];
            cube[arr[1]][1][0] = cube[arr[2]][0][1];
            cube[arr[1]][2][0] = cube[arr[2]][0][2];
            cube[arr[2]][0] = new char[]{cube[arr[3]][0][2],cube[arr[3]][1][2],cube[arr[3]][2][2]};
            cube[arr[3]][0][2] = tmp[0];
            cube[arr[3]][1][2] = tmp[1];
            cube[arr[3]][2][2] = tmp[2];
        }

    }
}
