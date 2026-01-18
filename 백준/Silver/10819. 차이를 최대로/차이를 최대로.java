import java.util.*;
import java.io.*;


class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] nums = new int[10];
    static boolean[] visited = new boolean[10];
    static int maximum = -1000;
    public static void recur(int step, int result, int prev) {

        if (step == N) {
            maximum = Math.max(result, maximum);
            return;
        }



        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            recur(step+1, (step > 0 ? result + Math.abs(nums[i] - prev) : result), nums[i]);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        recur(0, 0, 0);
        System.out.println(maximum);
    }
}