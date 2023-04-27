package Tree.트리순회;

import java.io.*;
import java.util.StringTokenizer;

class Node{
    String value;
    Node left;
    Node right;

    Node(String value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        }

    }
}
