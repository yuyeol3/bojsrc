import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        int N, M, x, y, K;
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        int[][] maps = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] diceValue = new int[7];
        // 위, 뒤, 오른쪽, 왼쪽, 앞쪽, 아래
        int[] dicePos = new int[]{0, 1, 2, 3, 4, 5, 6};

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken()) - 1;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            int top = dicePos[1];
            // 1. 동쪽 : 1->3, 3->6, 6->4, 4->1
            // 2. 서쪽 : 1->4, 4->6, 6->3, 3->1
            // 3. 남쪽 : 1->5, 5->6, 6->2, 2->1
            // 4. 북쪽 : 1->2, 2->6, 6->5, 5->1
            switch (dir) {
                case 0:
                    dicePos[1] = dicePos[4];
                    dicePos[4] = dicePos[6];
                    dicePos[6] = dicePos[3];
                    dicePos[3] = top;
                    break;
                case 1:
                    dicePos[1] = dicePos[3];
                    dicePos[3] = dicePos[6];
                    dicePos[6] = dicePos[4];
                    dicePos[4] = top;
                    break;
                case 2:
                    dicePos[1] = dicePos[5];
                    dicePos[5] = dicePos[6];
                    dicePos[6] = dicePos[2];
                    dicePos[2] = top;
                    break;
                case 3:
                    dicePos[1] = dicePos[2];
                    dicePos[2] = dicePos[6];
                    dicePos[6] = dicePos[5];
                    dicePos[5] = top;
                    break;

                default:
                    break;
            }

            if (maps[nx][ny] == 0) maps[nx][ny] = diceValue[dicePos[6]];
            else {
                diceValue[dicePos[6]] = maps[nx][ny];
                maps[nx][ny] = 0;
            }
            x = nx;
            y = ny;
            sb.append(diceValue[dicePos[1]]).append("\n");

        }
        System.out.print(sb);
    }
}