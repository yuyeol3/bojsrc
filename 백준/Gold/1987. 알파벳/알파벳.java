import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int R, C;
    static String[] board;
    static int maximum = 0;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new String[R];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine();
        }

        dfs(0, 0, (1 << (board[0].charAt(0) - 'A')), 1);

        System.out.println(maximum);
    }

    public static void dfs(int x, int y, int mask, int dist) {
        if (dist > maximum) maximum = dist;
        if (maximum == 26) return;

        int used = Integer.bitCount(mask);
        if (dist + (26 - used) <= maximum) return;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if (((mask >> (board[nx].charAt(ny) - 'A')) & 1) == 1) continue;

            dfs(nx, ny, mask | (1 << (board[nx].charAt(ny) - 'A')), dist+1);
        }
    }
}