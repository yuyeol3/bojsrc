import java.io.*;
import java.util.Arrays;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[] est = new int[N];

        for (int i = 0; i < N; i++) 
            est[i] = Integer.parseInt(br.readLine());

        Arrays.sort(est);
        int cutoff = (int) Math.round(N * 0.15);
        int avgBase = N - 2*cutoff;
        int summation = 0;
        // 01234
        for (int i = cutoff; i < N - cutoff; i++) {
            summation += est[i];
        }

        System.out.println(Math.round(summation * 1.0 / avgBase));
    }
}