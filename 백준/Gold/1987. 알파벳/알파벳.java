import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class State {
        public int x, y, mask, dist;
        public State(int x, int y, int mask, int dist) {
            this.x = x;
            this.y = y;
            this.mask = mask;
            this.dist = dist;
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        String[] board = new String[R];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine();
        }

        Deque<State> dq = new ArrayDeque<>();
        dq.addFirst(new State(
            0, 0, (1 << (board[0].charAt(0) - 'A')), 1
        ));

        int maximum = 0;
        while (!dq.isEmpty()) {
            State cur = dq.pollFirst();
            if (cur.dist > maximum) maximum = cur.dist;

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (((cur.mask >> (board[nx].charAt(ny) - 'A')) & 1) == 1) continue;

                dq.addFirst(new State(
                    nx, ny, cur.mask | (1 << (board[nx].charAt(ny) - 'A')), cur.dist+1
                ));
            }
        }

      

        System.out.println(maximum);
    }
}