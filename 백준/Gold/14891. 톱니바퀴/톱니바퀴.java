import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br 
        = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[][] wheels = new int[4][8];
        int[] ptrs = new int[]{2, 2, 2, 2};
        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheels[i][j] = line.charAt(j) - '0';
            }
        }


        // 회전의 전파를 어떻게??
        int K = Integer.parseInt(br.readLine());
        while (K-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int wheelNum = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            int prevRot = dir;
            ptrs[wheelNum] = rotate(ptrs[wheelNum], dir);
            for (int i = wheelNum + 1; i < 4; i++) {
                if (wheels[i][rotate(ptrs[i], 4)] == wheels[i-1][rotate(ptrs[i-1], -prevRot)]) {
                    break;
                }
                ptrs[i] = rotate(ptrs[i], -prevRot);
                prevRot = -prevRot;
            }

            prevRot = dir;
            for (int i = wheelNum - 1; i >= 0; i--) {
                if (wheels[i][ptrs[i]] == wheels[i+1][rotate(ptrs[i+1], 4-prevRot)]) {
                    break;
                }
                ptrs[i] = rotate(ptrs[i], -prevRot);
                prevRot = -prevRot;
            }

        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            int score = 1 << i;
            if (wheels[i][rotate(ptrs[i], 2)] == 1)
                answer += score;
        }
        System.out.println(answer);
        // System.out.println(rotate(2, 4));
    }

    static int rotate(int ptr, int amount) {
            return (8 + ptr - amount) % 8;
    }

    // static int rotateRight(int ptr) {
    //     return (ptr + 1) % 8;
    // }
}