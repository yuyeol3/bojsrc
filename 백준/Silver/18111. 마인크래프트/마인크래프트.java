import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] heightFreq = new int[257];
        int minHeight = 257;
        int maxHeight = -1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int h = Integer.parseInt(st.nextToken());
                heightFreq[h]++;
                if (h > maxHeight) maxHeight = h;
                if (h < minHeight) minHeight = h;
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

            for (int i = minHeight; i <= maxHeight; i++) {
                if (heightFreq[i] == 0) continue;
                if (i > h) {
                    elapsed += 2 * heightFreq[i] * (i - h);
                    requiredBlock -= heightFreq[i] * (i - h);
                }
                else if (i < h) {
                    elapsed += heightFreq[i] * (h - i);
                    requiredBlock += heightFreq[i] * (h - i);
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