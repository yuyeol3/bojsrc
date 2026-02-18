import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] fruits = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        int[] used = new int[10];
        used[fruits[0]] = 1;
        int maximum = 0;
        int distinct = 1;
        while (e < N && s <= e) {
            if (distinct > 2) {
                used[fruits[s]]--;
                if (used[fruits[s]] == 0) distinct--;
                s++;
            }
            else {
                maximum = Math.max(maximum, e-s+1);
                e++;
                if (e < N) {
                    used[fruits[e]]++;
                    if (used[fruits[e]] == 1) distinct++;
                }

            }
        }

        System.out.println(maximum);
    }
} 