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

        TreeMap<Integer, Integer> rangeQuery = new TreeMap<>();    
        int[] prefixSum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i-1] + Integer.parseInt(st.nextToken());
            rangeQuery.put(prefixSum[i], i);
        }

        int minLegth = MAX_LENGTH;
        for (int i = 1; i <= N; i++) {
            if (prefixSum[i] < S) continue;

            if (prefixSum[i] == S) {
                minLegth = i;
            }
            else {
                Map.Entry<Integer, Integer> et = rangeQuery.lowerEntry(prefixSum[i]-S+1);
                minLegth = Math.min(minLegth, et == null ? i : i - et.getValue());
            }
        }
        System.out.println(minLegth == MAX_LENGTH ? 0 : minLegth);
    }
}