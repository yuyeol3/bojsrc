import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static BufferedWriter bw;
    private static BufferedReader br;
    private static HashMap<String, String> dp;
    public static void main(String[] args) throws IOException {
        dp = new HashMap<>();
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        bw.write(String.format("%s\n",
                new BigInteger("2").pow(n).subtract(new BigInteger("1")))
        );

//        System.out.printf("%s\n", new BigInteger("2").pow(n).subtract(new BigInteger("1")));
        if (n <= 20) {
            bw.write(hanoi(n, 1, 2, 3));
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static String hanoi(int n, int from, int via, int to) throws IOException{
        if (n == 1) {
            return String.format("%d %d\n",from, to );
        }

        if (dp.containsKey(String.format("%d,%d,%d,%d", n, from, via, to)))
            return dp.get(String.format("%d,%d,%d,%d", n, from, via, to));

        String res = "";
        res += hanoi(n-1, from, to, via);
        res += String.format("%d %d\n",from, to );
        res +=hanoi(n-1, via, from, to);

        dp.put(String.format("%d,%d,%d,%d", n, from, via, to), res);
        return res;
    }
}
