import java.util.*;
import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer s = new StringTokenizer(br.readLine());
        long a = Long.parseLong(s.nextToken());
        long b = Long.parseLong(s.nextToken());

        int cnt = 0;
        long cur = b;

        while (true) {
            if (cur == a) 
                break;

            if (cur % 2 == 0 && cur / 2 >= a) {
                cur /= 2;
            }
            else if (cur % 10 == 1 && cur / 10 >= a) {
                cur /= 10;
            }
            else {
                bw.write(-1 + "\n");
                bw.flush();
                return;
            }
            cnt++;
        }
        
        bw.write((cnt+1) + "\n");
        bw.flush();
    }
}
