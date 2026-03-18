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
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            exists[nums[i]] = true;
        }


        for (int i = 0; i < n; i++) {
            for (int j = 1; j * j <= nums[i]; j++) {
                if (nums[i] % j != 0) continue;
                int r1 = j, r2 = nums[i] / j;

                if (exists[r1]) {
                    scores[r1]++;
                    scores[nums[i]]--;
                }

                if (r1 != r2 && exists[r2]) {
                    scores[r2]++;
                    scores[nums[i]]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(scores[num]).append(' ');
        }
        System.out.println(sb);

        /*
        naive idea

        O(N^2)

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (num[j] % num[i] == 0) {
                    score[i]++;
                    score[j]--;
                }
                else if (num[i] % num[j] == 0) {
                    score[i]--;
                    score[j]++;
                }
            }
        }
        
        만약 a % b == 0 이라면
        b의 약수에 의해서도 a는 나눠진다.

        n * sqrt(n) 으로 모든 수의 모든 약수를 구한다.

        100  -> 1 2 5 10 20 50 100

        */
    }
}