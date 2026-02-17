import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] cmap = new char[N+1][M+1];
        boolean[][] visited = new boolean[N+1][M+1];
        Pair initial = new Pair(0, 0);
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                cmap[i][j] = line.charAt(j);
                if (cmap[i][j] == 'I') {
                    initial.x = i;
                    initial.y = j;
                }
            }
        }

        Deque<Pair> q = new ArrayDeque<>();
        q.addLast(initial);
        visited[initial.x][initial.y] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            Pair s = q.pollFirst();
            if (cmap[s.x][s.y] == 'P') cnt++;

            for (int dir = 0; dir < 4; dir++) {
                int nx = s.x + dx[dir];
                int ny = s.y + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visited[nx][ny] || cmap[nx][ny] == 'X') continue;

                visited[nx][ny] = true;
                q.addLast(new Pair(nx, ny));
            }
        }

        System.out.println(cnt == 0 ? "TT" : cnt);

    }
}