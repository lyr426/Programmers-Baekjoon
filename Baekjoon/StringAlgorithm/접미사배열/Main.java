package 접미사배열;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        List<String> list = new ArrayList<>();
        for(int i=0; i<S.length(); i++){
            list.add(S.substring(i, S.length()));
        }
        Collections.sort(list);
        for(String str : list) {
            System.out.println(str);
        }

    }
}
