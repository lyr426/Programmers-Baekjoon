package 마법사상어와블리자드;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    static int[] bombedBall = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


//        for(int i=0; i<49; i++) {
//            for(int j=0; j<49; j++) {
//                System.out.print((int)(Math.random()*3)+1+" ");
//            }
//            System.out.println();
//        }
//        for(int i=0; i<100; i++) {
//            System.out.println("2 1");
//        }

        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] area = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> areaList = arrayToList(area);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int dir = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            ballRemove(areaList, dir, s);
            ballBomb(areaList);
            addBall(areaList, N);

//            System.out.println(i + "번째 ---------------");
//            for(int x : areaList) {
//                System.out.println(x);
//            }
        }



        int res = 0;
        for(int i=0; i<3; i++) {
            res += (i+1) * bombedBall[i];
        }
        bw.write(String.valueOf(res));
        bw.flush();

    }

    private static void addBall(List<Integer> areaList, int N) {

        for(int i=1; i<areaList.size(); i++) {
            if(areaList.get(i) == 0){
                return;
            }
            int num = areaList.get(i);
            int cnt = 0;
            while (areaList.size() > i && areaList.get(i) == num) {
                areaList.remove(i);
                cnt += 1;
            }
            areaList.add(i,cnt);
            areaList.add(i+1, num);
            i++;
        }

        if(areaList.size() > N*N) {
            areaList = areaList.subList(0, N * N - 1);
        }
//        while(areaList.size() > N * N){
//            areaList.remove(areaList.size()-1);
//        }
    }
//    private static void addBall(List<Integer> areaList, int N) {
//        int[] arr = areaList.stream().mapToInt(i->i).toArray();
//
//        int removeCnt = 0;
//        int addCnt = 0;
//        for(int i=1; i<areaList.size(); i++) {
//            if( i+removeCnt-addCnt > arr.length -1 || arr[i+removeCnt-addCnt] == 0){
//                return;
//            }
//            int num = arr[i+removeCnt-addCnt];
//            int cnt = 0;
//            while (areaList.size() > i && i+removeCnt-addCnt < arr.length -1 && arr[i + removeCnt-addCnt] == num) {
//                areaList.remove(i);
//                removeCnt += 1;
//                cnt += 1;
//            }
//            areaList.add(i,cnt);
//            areaList.add(i+1, num);
//            addCnt += 1;
//            i++;
//        }
//
//        while(areaList.size() > N * N){
//            areaList.remove(areaList.size()-1);
//        }
//    }

    private static void ballBomb(List<Integer> areaList) {
        boolean flag = false;

        while (!flag) {
            int[] arr = areaList.stream().mapToInt(i->i).toArray();
            int removeCnt = 0;
            flag = true;
            for(int i=1; i<areaList.size(); i++) {
                int cnt = 1;
                int num = areaList.get(i);
                if(num == 0) break;
                for(int j=i+1; j<areaList.size(); j++) {
                    if(areaList.get(j) != num) {
                        break;
                    }
//                    if(arr[j+removeCnt] != num) {
//                        break;
//                    }
                    cnt += 1;
                    if(cnt >= 4){
                        cnt = 0;
                        while(areaList.get(i) == num){
                            cnt += 1;
                            areaList.remove(i);
                        }
//                        while(arr[i+removeCnt] == num){
//                            cnt += 1;
//                            removeCnt +=1;
//                            areaList.remove(i);
//                        }
                        bombedBall[num-1] += cnt;
                        flag = false;
                        break;
                    }
                }
            }
        }

    }

    private static void ballRemove(List<Integer> areaList, int dir, int s) {
        int[] di = {3, 1, 0, 2};
        int target = 0;
        int m = 1;
        for(int i=0; i<s; i++) {
            for(int j=0; j<4; j++) {
                target += m;
                if(j == 0) {
                    m += 1;
                }
                if(di[dir-1] == j) {
                    areaList.remove((int)target-i);
                }
            }
            m += 1;
        }

    }

    private static List<Integer> arrayToList(int[][] area) {
        List<Integer> list = new Vector<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        int N = area.length;
        int x = N/2;
        int y = N/2;
        int repeat = 1;
        int dir = 0;

        while(x != 0 || y != 0){
            for(int i=0; i<2; i++) {
                for(int j=0; j<repeat; j++) {
                    if(x < 0|| y < 0) {
                        return list;
                    }
                    list.add(area[x][y]);
                    x += dx[dir];
                    y += dy[dir];
                }
                dir = (dir + 1)%4;
            }
            repeat += 1;
        }

        return list;
    }
}
