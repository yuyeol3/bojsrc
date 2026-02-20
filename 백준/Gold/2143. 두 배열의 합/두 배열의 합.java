import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        
        int N = Integer.parseInt(br.readLine());
        int[] prefixA = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            prefixA[i] = prefixA[i-1] + Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] prefixB = new int[M+1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= M; i++) {
            prefixB[i] = prefixB[i-1] + Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> possibleA = new HashMap<>();

        // O(N^2)
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                int sum = prefixA[j] - prefixA[i-1];
                possibleA.computeIfPresent(sum, (k, v)-> v+1);
                possibleA.computeIfAbsent(sum, k->1);
            }
        }
        // System.out.println(possibleA);
        
        // O(M^2)
        long cases = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = i; j <= M; j++) {
                int sum = prefixB[j] - prefixB[i-1];
                if (possibleA.containsKey(T-sum)) {
                    cases += possibleA.get(T-sum);
                }
            }
        }

        System.out.println(cases);
    }

}