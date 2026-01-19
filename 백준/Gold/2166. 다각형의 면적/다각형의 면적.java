import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Pair {
        public long a, b;
        public Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long leftDir = 0;
        long rightDir = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        Pair first = new Pair(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Pair prev = first;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Pair cur = new Pair(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

            rightDir += prev.a * cur.b;
            leftDir += prev.b * cur.a;
            prev = cur;
        }

        rightDir += prev.a * first.b;
        leftDir += prev.b * first.a;

        // System.out.println(rightDir + " " + leftDir);
        double result = Double.valueOf(Math.abs(rightDir-leftDir))/2.0D;
        System.out.printf("%.1f", result);
    }


}