package 베스트셀러;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, Integer> books = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String book = br.readLine();
            books.put(book, books.getOrDefault(book, 0)+1);
        }
        int best = -1;
        String best_book = "";
        for(String s: books.keySet()){
            if((books.get(s) == best && s.compareTo(best_book)<0)||books.get(s) > best){
                best = books.get(s);
                best_book = s;
            }
        }
        bw.write(best_book);
        bw.flush();
    }
}
