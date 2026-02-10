import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int MX = 1000001;
    static int[] scores = new int[MX];
    static boolean[] exists = new boolean[MX];

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int maximum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            maximum = Math.max(maximum, nums[i]);
            exists[nums[i]] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int target = 2 * nums[i]; target <= maximum; target += nums[i] ) {
                if (!exists[target]) continue;
                scores[target]--;
                scores[nums[i]]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(scores[num]).append(' ');
        }
        System.out.println(sb);


    }
}