import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        char[] bin = br.readLine().toCharArray();
        int k = Integer.parseInt(br.readLine());

        int p = N-1;
        while (k-->0 && p >= 0) {
            if (bin[p--] != '0') {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}