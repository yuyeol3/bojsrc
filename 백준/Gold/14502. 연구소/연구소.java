import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[] chosen = new int[3];
    static int[][] maps;
    static List<int[]> viruses;
    static int N, M;
    static int blanks;
    static int maximum = 0;

    static void comb(int prev, int step) {
        if (step == 3) {
            int ax = chosen[0] / M;
            int ay = chosen[0] % M;

            int bx = chosen[1] / M;
            int by = chosen[1] % M;

            int cx = chosen[2] / M;
            int cy = chosen[2] % M;

            int result = bfs(maps, viruses, blanks, ax, ay, bx, by, cx, cy);
            if (maximum < result) maximum = result;
            return;
        }

        for (int i = prev + 1; i < N * M; i++) {
            if (maps[i/M][i%M] != 0) continue;
            chosen[step] = i;
            comb(i, step + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maps = new int[N][M];
        viruses = new ArrayList<>();
        blanks = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if (maps[i][j] == 2) 
                    viruses.add(new int[]{i, j});

                if (maps[i][j] == 0) 
                    blanks++;
            }
        }        

        
        /*
        0 1 
        2 3
        4 5 -> 4 (2, 0)
        */
        comb(-1, 0);
        System.out.println(maximum);
    }

    static int bfs(
        int[][] maps, 
        List<int[]> viruses,
        int blanks,
        int x1, int y1, 
        int x2, int y2,
        int x3, int y3
    ) {
        int n = maps.length;
        int m = maps[0].length;

        int result = blanks-3;
        boolean[][] visited = new boolean[n][m];

        Deque<int[]> q = new ArrayDeque<>();
        
        for (int[] virus : viruses) {
            q.offerLast(virus);
            visited[virus[0]][virus[1]] = true;
        }


        while (!q.isEmpty()) {
            int[] s = q.pollFirst();

            for (int dir = 0; dir < 4; dir++) {
                int nx = s[0] + dx[dir];
                int ny = s[1] + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny] || maps[nx][ny] == 1) continue;
                if ((nx == x1 && ny == y1) || (nx == x2 && ny == y2) || (nx == x3 && ny == y3)) 
                    continue;

                result--;
                visited[nx][ny] = true;
                q.offerLast(new int[]{nx, ny});
            }
        }

        return result;
    }
}