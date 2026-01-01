import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] l = br.readLine().split(" ");
            int a = Integer.parseInt(l[0]);
            int b = Integer.parseInt(l[1]);
            bw.write(a+b + "");
            bw.write('\n');
        }

        bw.flush();
        bw.close();
    }
}