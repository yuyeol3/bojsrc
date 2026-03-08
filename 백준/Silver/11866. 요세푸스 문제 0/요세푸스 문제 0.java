import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++)
            dq.addLast(i);
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!dq.isEmpty()) {
            for (int i = 0; i < K-1; i++) {
                int num = dq.poll();
                dq.addLast(num);
            }
            sb.append(dq.poll() + (dq.isEmpty() ? ">" : ", "));
        }
        System.out.println(sb.toString());
    }

}