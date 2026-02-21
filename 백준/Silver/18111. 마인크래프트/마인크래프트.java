import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] world = new int[N][M];
        int minHeight = 257;
        int maxHeight = -1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                world[i][j] = Integer.parseInt(st.nextToken());
                if (world[i][j] > maxHeight) maxHeight = world[i][j];
                if (world[i][j] < minHeight) minHeight = world[i][j];
            }
        }

        if (minHeight == maxHeight) {
            System.out.println(0 + " " + minHeight);
            return;
        }

        int minElapsed = Integer.MAX_VALUE;
        int minElapsedH = 257;
        for (int h = maxHeight; h >= minHeight; h--) {
            int elapsed = 0;
            int requiredBlock = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (world[i][j] > h) {
                        elapsed += 2 * (world[i][j] - h);
                        requiredBlock -= world[i][j] - h;
                    }
                    else if (world[i][j] < h) {
                        elapsed += h - world[i][j];
                        requiredBlock += h - world[i][j];
                    }
                }
            }

            if (requiredBlock > B) continue;
            if (elapsed < minElapsed) {
                minElapsed = elapsed;
                minElapsedH = h;
            }
        }

        System.out.println(minElapsed + " " + minElapsedH);
    }
}