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
        List<Integer> primes = new ArrayList<>();
        Arrays.fill(isPrime, true);

        for (int i = 2; i <= N; i++) {
            if (!isPrime[i]) continue;
            primes.add(i);
            for (int j = i; j <= N; j += i) {
                isPrime[j] = false;
            }
        }
        int cases = 0;
        int s, e;
        s = e = 0;

        int sum = primes.get(0);
        while (e < primes.size()) {
            cases += sum == N ? 1 : 0;

            if (sum >= N) {
                sum -= primes.get(s++);
            }
            else {
                if (e + 1 == primes.size()) break;
                sum += primes.get(++e);
            }
        }

        System.out.println(cases);
    }
}