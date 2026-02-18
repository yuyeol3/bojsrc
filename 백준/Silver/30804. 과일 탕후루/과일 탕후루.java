import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        /*
        5 1 1 2 1
        1 2 2 3 3

        1 2 3 4 5 6 7 8 9
        1 2 3 4 5 6 7 8 9

        5 1 1 2 1 3 4 1 1
        1 2 2 3 3 4 5 5 5
        5 4 4 4 3 3 2 1 1
        */       

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
        while (e < N && s <= e) {
            
            // System.out.println(s + "," + e + "," + Arrays.toString(used));

            int usedFruits = 0;
            for (int i = 1; i <= 9; i++) {
                usedFruits += (used[i] > 0) ? 1 : 0;
            }

            if (usedFruits > 2) {
                used[fruits[s]]--;
                s++;
            }
            else {
                maximum = Math.max(maximum, e-s+1);
                e++;
                if (e < N) used[fruits[e]]++;
            }
        }

        System.out.println(maximum);
    }
} 