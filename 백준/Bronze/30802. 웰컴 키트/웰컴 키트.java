import java.util.*;
import java.io.*;


class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] sizes = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            sizes[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int shirtPacks = 0;
        for (int size : sizes) {
            shirtPacks += (size / T) + (size % T > 0 ? 1 : 0);
        }
        bw.write(shirtPacks + "\n");

        int penPacks = N / P;
        int penPacksOne = N % P;
        bw.write(penPacks + " " + penPacksOne + "\n");

        bw.flush();
    }
}