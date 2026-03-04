import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] ladders = new int[101];
        int[] snakes = new int[101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ladders[a] = b;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            snakes[a] = b;
        }

        int[] dist = new int[101];
        Arrays.fill(dist, 102);

        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(1);
        dist[1] = 0;
        while (!q.isEmpty()) {
            int s = q.pollFirst();
            // System.out.println("id="+s);
            // if (id == 100)
            //     break;
            if (snakes[s] != 0) {
                if (dist[snakes[s]] <= dist[s]) continue;
                dist[snakes[s]] = dist[s];
                q.offerLast(snakes[s]);
                continue;
            }
            else if (ladders[s] != 0) {
                if (dist[ladders[s]] <= dist[s]) continue;
                dist[ladders[s]] = dist[s];
                q.offerLast(ladders[s]);
                continue;
            }


            for (int i = 1; i <= 6; i++) {
                int nid = s+i;
                int ndist = dist[s] + 1;

                // System.out.println("id,nx,ny="+ id + "," + nx + "," + ny);

                if (nid > 100) continue;
                if (dist[nid] <= ndist) continue;
                
                dist[nid] = ndist;
                q.offerLast(nid);
            }
            
        }

        // for (int i = 0; i < 10; i++) {
        //     for (int j = 0; j < 10; j++) {
        //         System.out.print(dist[(i*10+j)+1] + " ");
        //     }
        //     System.out.println();
        // }
        System.out.println(dist[100]);
    }
    
    
}