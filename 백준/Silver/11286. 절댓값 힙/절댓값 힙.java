import java.util.*;
import java.io.*;


class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            if (Math.abs(a) == Math.abs(b)) 
                return Integer.compare(a, b);

            return Integer.compare(Math.abs(a), Math.abs(b));
        });

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                Integer i = pq.peek();
                sb.append(i == null ? 0 : i).append("\n");
                if (i != null) pq.poll();
            }
            else {
                pq.offer(input);
            }
        }
        System.out.println(sb);
    }
}