import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long leftDir = 0;
        long rightDir = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        long firstX = Long.parseLong(st.nextToken());
        long firstY = Long.parseLong(st.nextToken());
        long prevX = firstX;
        long prevY = firstY;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long curX = Long.parseLong(st.nextToken());
            long curY = Long.parseLong(st.nextToken());

            rightDir += prevX * curY;
            leftDir += prevY * curX;
            prevX = curX; prevY = curY;
        }

        rightDir += prevX * firstY;
        leftDir += prevY * firstX;

        double result = Math.abs(rightDir-leftDir)/2.0D;
        System.out.printf("%.1f", result);
    }


}