import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());


        StringBuilder sb = new StringBuilder();
        for (int len = L; len <= 100; len++) {
            int s = 2*N - len*len + len;
            if (s >= 0 && s % (2*len) == 0) {
                s /= 2*len;
                for (int j = s; j < s+len; j++) {
                    sb.append(j).append(" ");
                }
                System.out.println(sb);
                return;
            }
        }
        System.out.println(-1);
    }

}