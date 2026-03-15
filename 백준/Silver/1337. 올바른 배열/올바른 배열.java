import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int minRequired = 6;

        for (int i = 0; i < N; i++) {
            int base = arr[i];
            int left = 4;

            for (int j = i+1; j < Math.min(i+5, N); j++) {
                if (arr[j] < base + 5)
                    left--;
            }
            if (left < minRequired)
                minRequired = left;
        }

        System.out.println(minRequired);
    }
}