import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int OFFSET = 100;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[201];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int e = Integer.parseInt(st.nextToken());
            nums[e+OFFSET]++;
        }

        int v = Integer.parseInt(br.readLine()) + OFFSET;
        System.out.println(nums[v]);

    }
}