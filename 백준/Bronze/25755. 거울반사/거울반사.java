import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] rev = {-1, 1, 5, -1, -1, 2, -1, -1, 8, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String dir = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        if (dir.equals("L") || dir.equals("R")) {
            for (int i = 0; i < N; i++) {
                for (int j = N-1; j >=0; j--) {
                    sb.append(rev[arr[i][j]] == -1 ? "?" : rev[arr[i][j]]).append(" ");
                }
                sb.append("\n");
            }
        }
        else if (dir.equals("U") || dir.equals("D")) {
            for (int i = N-1; i >= 0; i--) {
                for (int j = 0; j < N; j++) {
                    sb.append(rev[arr[i][j]] == -1 ? "?" : rev[arr[i][j]]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}