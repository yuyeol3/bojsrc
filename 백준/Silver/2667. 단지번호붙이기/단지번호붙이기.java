import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        char[][] aptMap = new char[N][N];
        for (int i = 0; i < N; i++) {
            String ln = br.readLine();
            for (int j = 0; j < N; j++) {
                aptMap[i][j] = ln.charAt(j);
            }
        }

        boolean[][] visited = new boolean[N][N];
        int[] bldgs = new int[N*N+1];
        int bidx = 0;

        Deque<Pair> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (aptMap[i][j] == '0' || visited[i][j]) continue;

                q.addLast(new Pair(i, j));
                bldgs[bidx]++;
                visited[i][j] = true;
                
                while (!q.isEmpty()) {
                    Pair p = q.pollFirst();

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = p.x + dx[dir];
                        int ny = p.y + dy[dir];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if (visited[nx][ny] || aptMap[nx][ny] == '0') continue;

                        visited[nx][ny] = true;
                        bldgs[bidx]++;
                        q.addLast(new Pair(nx, ny));
                    }
                }

                bidx++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bidx).append("\n");
        Arrays.sort(bldgs, 0, bidx);
        for (int i = 0; i < bidx; i++) {
            sb.append(bldgs[i]).append("\n");
        }
        System.out.print(sb);
    }
}