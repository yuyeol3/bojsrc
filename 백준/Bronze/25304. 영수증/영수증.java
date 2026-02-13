import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        long tot = Long.parseLong(br.readLine());
        int n = Integer.parseInt(br.readLine());

        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int unitPrice = Integer.parseInt(st.nextToken());
            int qtt = Integer.parseInt(st.nextToken());
            tot -= unitPrice*qtt;
        }

        System.out.println(tot==0 ? "Yes" : "No");
    }

}