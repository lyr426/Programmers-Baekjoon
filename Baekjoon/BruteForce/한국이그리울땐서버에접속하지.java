import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] pattern = br.readLine().split("\\*");
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.startsWith(pattern[0])) {
                str = str.substring(pattern[0].length());
                if (str.endsWith(pattern[1])) {
                    bw.write("DA\n");
                    continue;
                }
            }
            bw.write("NE\n");
        }
        bw.flush();
        bw.close();
    }
}
