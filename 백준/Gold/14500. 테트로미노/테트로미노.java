import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[][][] tetrominos = new int[][][]{
        {{1, 1, 1, 1}},
        {
            {1, 1},
            {1, 1}
        },
        {
            {1, 0},
            {1, 0},
            {1, 1}
        },
        {
            {1, 0},
            {1, 1},
            {0, 1}
        },
        {
            {1, 1, 1},
            {0, 1, 0}
        }
    };

    static int[][] rotate90(int[][] tetromino) {
        int r = tetromino.length;
        int c = tetromino[0].length;

        int[][] rotated = new int[c][r];

        int x, y;
        x = y = 0;
        for (int i = r-1; i >= 0; i--) {
            for (int j = 0; j < c; j++) {
                rotated[x][y] = tetromino[i][j];
                x = (x + 1) % c;
                y += (x == 0 ? 1 : 0);
            }
        }

        return rotated;
    }

    static int[][] hflip(int[][] tetromino) {
        int r = tetromino.length;
        int c = tetromino[0].length;

        int[][] flipped = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                flipped[i][j] = tetromino[r-i-1][j];
            }
        }
        return flipped;
    }

    static int[][] vflip(int[][] tetromino) {
        int r = tetromino.length;
        int c = tetromino[0].length;

        int[][] flipped = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                flipped[i][j] = tetromino[i][c-j-1];
            }
        }
        return flipped;
    }


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] nums = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        List<int[][]> allTets = new ArrayList<>();

        for (int i = 0; i < tetrominos.length; i++) {
            allTets.add(tetrominos[i]);
            allTets.add(vflip(tetrominos[i]));
            allTets.add(hflip(tetrominos[i]));
        }

        int n = allTets.size();
        for (int i = 0; i < n; i++) {
            int[][] rot90 = rotate90(allTets.get(i));
            int[][] rot180 = rotate90(rot90);
            int[][] rot270 = rotate90(rot180);

            allTets.add(rot90);
            allTets.add(rot180);
            allTets.add(rot270);
        }

        int maximum = 0;
        n = allTets.size();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < n; k++) {
                    int[][] tetromino = allTets.get(k);
                    int r = tetromino.length;
                    int c = tetromino[0].length;

                    if (i + r > N || j + c > M) continue;
                    int sum = 0;
                    for (int x = 0; x < r; x++) {
                        for (int y = 0; y < c; y++) {
                            if (tetromino[x][y] == 1) {
                                sum += nums[x+i][y+j];
                            }
                        }
                    }

                    if (sum > maximum)
                        maximum = sum;
                }
            }
        }
        System.out.println(maximum);

    }
}