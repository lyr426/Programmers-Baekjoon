import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        LinkedList<String> list = new LinkedList<>();

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                String num = "";
                while (j<str.length() &&str.charAt(j) >= '0' && str.charAt(j)<='9'){
                    if(num.length()>0&&num.charAt(0)=='0'&&str.charAt(j)=='0'){
                        j++;
                        continue;
                    }
                    num+=str.charAt(j);
                    j++;
                }
                if(num.length()>0) {
                    if(num.length()>1 && num.charAt(0)=='0') num = num.substring(1);
                    list.add(num);
                }
            }
        }
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };
        Collections.sort(list, c);
        for(String x:list) bw.write(x+"\n");
        bw.flush();
        bw.close();
    }
}