import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class State {
        public int dir;  // 1 : 가로, 2 : 세로, 3 : 대각선
        public int r, c;

        public State(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }

    static int[] dr = {0, 1, 1};
    static int[] dc = {1, 0, 1};

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int arr[][] = new int[N+5][N+5];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Deque<State> dq = new ArrayDeque<>();
        dq.addLast(new State(1, 2, 1));
        int result = 0;

        while (!dq.isEmpty()) {
            State s = dq.poll();
            if (s.r == N && s.c == N) {
                result++;
                continue;
            }

            for (int i = 0; i < 3; i++) {
                if (s.dir == 1 && i == 1) continue;
                if (s.dir == 2 && i == 0) continue;

                int cr = s.r + dr[i];
                int cc = s.c + dc[i];

                if (cr < 1 || cr > N) continue;
                if (cc < 1 || cc > N) continue;
                if (arr[cr][cc] > 0) continue;
                if (i == 2 && (arr[cr-1][cc] > 0 || arr[cr][cc-1] > 0))
                    continue;


                dq.addLast(new State(cr, cc, i+1));
            }

        }

        bw.write(result + "\n");
        bw.flush();
    }
}