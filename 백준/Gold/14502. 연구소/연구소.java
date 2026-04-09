import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] maps = new int[N][M];
        List<int[]> viruses = new ArrayList<>();
        int blanks = 0;
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
        int maximum = 0;
        for (int i = 0; i < N*M; i++) {
            int ax = i / M;
            int ay = i % M;
            if (maps[ax][ay] != 0) continue;
            for (int j = i+1; j < N*M; j++) {
                int bx = j / M;
                int by = j % M;
                if (maps[bx][by] != 0) continue;

                for (int k = j+1; k < N*M; k++) {
                    int cx = k / M;
                    int cy = k % M;
                    if (maps[cx][cy] != 0) continue;
                    // System.out.println("ax,ay,bx,by,cx,cy="+ax+","+ay+","+bx+","+by+","+cx+","+cy);

                    int result 
                        = bfs(maps, viruses, blanks, ax, ay, bx, by, cx, cy);

                    if (maximum < result) maximum = result;

                }
            }
        }
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