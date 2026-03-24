import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
       StringTokenizer st = new StringTokenizer(br.readLine());
       
       int n = Integer.parseInt(st.nextToken());
       int m = Integer.parseInt(st.nextToken());

       int[] buckets = new int[n+1];
       for (int i = 1; i <= n; i++) {
            buckets[i] = i;
       }
       
       for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j <= (y+x)/2; j++) {
                int lastIdx = y + x - j;
                int tmp = buckets[j];
                // System.out.println("j,lastIdx="+j+","+lastIdx);
                buckets[j] = buckets[lastIdx];
                buckets[lastIdx] = tmp;
            }
       }

       StringBuilder sb = new StringBuilder();
       for (int i = 1; i <= n; i++) {
            sb.append(buckets[i]).append(" ");
       }
       System.out.println(sb);
    }
}