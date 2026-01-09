import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final long r = 31;
    static final long M = 1234567891L;
    public static void main(String[] args) throws IOException {
        long L = Integer.parseInt(br.readLine());
        String s = br.readLine();

        long hashed = 0;
        for (int i = 0; i < L; i++) {
            char c = s.charAt(i);
            long cnum = (c - 'a') + 1;

            long term = cnum;
            for (int j = 0; j < i; j++) {
                term = (term * r) % M;
            }
            hashed = (hashed + term) % M;
        }

        bw.write(hashed + "\n");
        bw.flush();
    }
}