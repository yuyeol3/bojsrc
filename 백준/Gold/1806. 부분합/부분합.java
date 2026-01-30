import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int MAX_LENGTH = 100005;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, S;
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        int[] prefixSum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i-1] + Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int u = 1;
        int minLength = MAX_LENGTH;
        while (l < u && u <= N) {
            int sectionSum = prefixSum[u]-prefixSum[l];
            if (sectionSum >= S) {
                minLength = Math.min(minLength, u-l);
                l++;
            }
            else {
                u++;
            }
        }
        System.out.println(minLength == MAX_LENGTH ? 0 : minLength);
    }
}