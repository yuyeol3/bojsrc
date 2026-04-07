import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class State {
        int rx, ry, bx, by;
        int dist;

        public State(int rx, int ry, int bx, int by, int dist) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.dist = dist;
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] maps = new char[N][M];
        int rx, ry, bx, by, ox, oy;
        rx = ry = bx = by = ox = oy =  0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maps[i][j] = line.charAt(j);
                if (maps[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }
                if (maps[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
                if (maps[i][j] == 'O') {
                    ox = i;
                    oy = j;
                }
            }
        }

        // 여기에 넣는 상태는 무조건 멈춘 상태임
        Deque<State> q = new ArrayDeque<>();
        q.offerLast(new State(rx, ry, bx, by,  0));
        // int[][][][] visited = new int[N][M][N][M];

        int[][][][] visited = new int[N][M][N][M];
        // for (int i = 0; i < N; i++)
        //     Arrays.fill(visited[i], Integer.MAX_VALUE);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    for (int h = 0; h < M; h++) {
                        visited[i][j][k][h] = Integer.MAX_VALUE;
                    }
                }
            }
        }

        visited[rx][ry][bx][by] = 0;
        // visited[rs]
        while (!q.isEmpty()) {
            State s = q.pollFirst();

            // System.out.println("rx,ry,bx,by="+s.rx+","+s.ry+","+s.bx+","+s.by);
            if (s.rx == ox && s.ry == oy) {
                System.out.println(s.dist <= 10 ? s.dist : -1);
                return;
            }

            if (s.dist >= 10) continue;
            
            for (int dir = 0; dir < 4; dir++) {
                int rcx = s.rx;
                int rcy = s.ry;
                int bcx = s.bx;
                int bcy = s.by;

                int rnx, rny, bnx, bny;
                rnx = rny = bnx = bny = 0;
                while (true) {
                    rnx = rcx + dx[dir];
                    rny = rcy + dy[dir];
                    bnx = bcx + dx[dir];
                    bny = bcy + dy[dir];
                    // System.out.println("rnx,rny,bnx,bny="+rnx+","+rny+","+bnx+","+bny);
                    if (maps[rnx][rny] == '#' || maps[rcx][rcy] == 'O') {
                        rnx = rcx;
                        rny = rcy;
                    }
                    if (maps[bnx][bny] == '#' || maps[bcx][bcy] == 'O') {
                        bnx = bcx;
                        bny = bcy;
                    }

                    // if (bnx == rnx && bny == rny && (rnx != ox && rny != oy)) {
                    //     break;
                    // }

                    if (bnx == rnx && bny == rny) {
                        if (maps[bnx][bny] == 'O') {
                            rcx = rnx;
                            rcy = rny;
                            bcx = bnx;
                            bcy = bny;
                        }
                        break;
                    }

                    if ((rnx == rcx && rny == rcy) && (bnx == bcx && bny == bcy))
                        break;

                    rcx = rnx;
                    rcy = rny;
                    bcx = bnx;
                    bcy = bny;
                    // 1. 벽에 부딪힐 때까지 전진
                    // 2. 구멍에 들어간 경우
                    // 3. 두 구슬이 겹치면 안됨
                }

                if (maps[bcx][bcy] == 'O') continue;

                if (visited[rcx][rcy][bcx][bcy] <= s.dist + 1)
                    continue;

                State ns = new State(
                    rcx,
                    rcy, 
                    bcx,
                    bcy,
                    s.dist + 1
                );

                visited[rcx][rcy][bcx][bcy] = s.dist + 1;
                q.offerLast(ns);
            }
        }
        // System.out.println(answer);
        System.out.println(-1);
            
    }
}