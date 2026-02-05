import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[][] mat;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N;
        long B;

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        mat = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] res = matPow(B);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(res[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static int[][] matMul(final int[][] a, final int[][] b) {
        int n = a.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++)
                    result[i][j] = (result[i][j] + a[i][k] * b[k][j]) % 1000;
            }
        }

        return result;
    }

    static int[][] matPow(long n) {
        if (n == 1)
            return mat;
        
        if (n % 2 == 0) {
            int[][] half = matPow(n / 2);
            return matMul(half, half);
        }

        return matMul(mat, matPow(n-1));
    }
}