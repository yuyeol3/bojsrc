import java.util.*;
import java.io.*;


class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] nums = new int[10];
    static int[] selected = new int[10];
    static boolean[] visited = new boolean[10];
    static int maximum = -1000;
    public static void recur(int step) {

        if (step == N) {
            int result = 0;
            for (int i = 1; i < N; i++) {
                result += Math.abs(selected[i] - selected[i-1]);
            }
            maximum = Math.max(result, maximum);
            return;
        }


        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            selected[step] = nums[i];
            recur(step+1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        recur(0);
        System.out.println(maximum);
    }
}