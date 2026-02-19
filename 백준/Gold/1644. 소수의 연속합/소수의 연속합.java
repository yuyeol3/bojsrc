import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        boolean[] isPrime = new boolean[N+1];
        int[] primes = new int[N+1];
        int pnum = 0;
        Arrays.fill(isPrime, true);

        for (int i = 2; i <= N; i++) {
            if (!isPrime[i]) continue;
            primes[pnum++] = i;
            for (int j = 2*i; j <= N; j += i) {
                isPrime[j] = false;
            }
        }
        int cases = 0;
        int s, e;
        s = e = 0;

        int sum = primes[0];
        while (e < pnum) {
            if (sum == N) cases++;

            if (sum >= N) {
                sum -= primes[s++];
            }
            else {
                if (e + 1 == pnum) break;
                sum += primes[++e];
            }
        }

        System.out.println(cases);
    }
}