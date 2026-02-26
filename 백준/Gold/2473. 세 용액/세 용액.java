import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long[] sols = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sols[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(sols);

        long[] candidates = new long[3];
        long dist = 1000000000L * 5000 + 5;
        for (int i = 0; i < N; i++) {
            int s = (0 == i ? 1 : 0);
            int e = (N - 1 == i ? N-2: N-1);
            long sum = sols[s] + sols[e] + sols[i];
            while (s < e) {
                if (e == i) {
                    e--;
                    continue;
                }

                if (s == i) {
                    s++;
                    continue;
                }
                sum = sols[s] + sols[e] + sols[i];
                if (dist > Math.abs(sum)) {
                    candidates[0] = sols[i];
                    candidates[1] = sols[s];
                    candidates[2] = sols[e];
                    dist = Math.abs(sum);
                }
                if (sum > 0) {
                    e--;
                }
                else if (sum < 0) {
                    s++;
                }
                else {
                    break;
                }
            }
        }

        Arrays.sort(candidates);
        System.out.println(candidates[0] + " " + candidates[1] + " " + candidates[2]);
    }
}