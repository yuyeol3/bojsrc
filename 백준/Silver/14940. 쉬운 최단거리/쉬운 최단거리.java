import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) 
            Arrays.fill(dist[i], -1);

        Deque<List<Integer>> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    q.offerLast(List.of(i,j));
                    dist[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            List<Integer> s = q.pollFirst();

            for (int dir = 0; dir < 4; dir++) {
                int nx = s.get(0) + dx[dir];
                int ny = s.get(1) + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (dist[nx][ny] != -1 || map[nx][ny] == 0) continue;

                dist[nx][ny] = dist[s.get(0)][s.get(1)] + 1;
                q.offerLast(List.of(nx, ny));
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] == -1 && map[i][j] == 0) sb.append(0);
                else if (dist[i][j] == -1 && map[i][j] == 1) sb.append(-1);
                else sb.append(dist[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}