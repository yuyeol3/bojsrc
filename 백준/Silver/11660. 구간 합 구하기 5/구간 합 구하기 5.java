import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[][] table;
    static int[][] pSum;



    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        table = new int[N][N];
        pSum = new int[N][N];

        // bw.write("N = " + N + "\n");

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pSum[0][0] = table[0][0];
        for (int i = 1; i < N; i++) {
            pSum[i][0] = table[i][0] + pSum[i-1][0];
            pSum[0][i] = table[0][i] + pSum[0][i-1];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                pSum[i][j] = table[i][j] + pSum[i-1][j] + pSum[i][j-1] - pSum[i-1][j-1];
            }
        }
        // printPsum();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1, y1, x2, y2;
            x1 = Integer.parseInt(st.nextToken()) -1;
            y1 = Integer.parseInt(st.nextToken()) -1;
            x2 = Integer.parseInt(st.nextToken()) -1;
            y2 = Integer.parseInt(st.nextToken()) -1;

            int result = pSum[x2][y2];
            if (x1 >= 1) result -= pSum[x1-1][y2];
            if (y1 >= 1) result -= pSum[x2][y1-1];
            if (x1 >= 1 && y1 >= 1) result += pSum[x1-1][y1-1];
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }

}

