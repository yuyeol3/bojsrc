import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b, a));
        StringBuilder sb = new StringBuilder();
        while (N-->0) {
            int num = Integer.parseInt(br.readLine());

            switch (num) {
                case 0:
                    sb.append(pq.peek() == null ? 0 : pq.poll()).append("\n");
                    break;
                default:
                    pq.offer(num);
                    break;
            }
        }
        System.out.print(sb);
    }
}