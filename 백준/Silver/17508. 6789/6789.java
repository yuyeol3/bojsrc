import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] matOrgin = new int[n][m];

        for (int i = 0; i < n; i++) {
            String ln = br.readLine();
            for (int j = 0; j < m; j++) {
                matOrgin[i][j] = ln.charAt(j) - '0';
            }
        }

        int px = 0, py = 0;
        int qx = n-1, qy = m-1;

        int count = 0;

        while (px < qx || (px == qx && py <= qy)) {
            // System.out.println("px,py,qx,qy=" + px + "," + py + "," + qx + "," + qy);
            
            if (px == qx && py == qy && matOrgin[px][py] != 8) {
                System.out.println(-1);
                return;
            }

            if ((matOrgin[px][py] == 6 && matOrgin[qx][qy] == 6) || 
                (matOrgin[px][py] == 9 && matOrgin[qx][qy] == 9) || 
                (matOrgin[px][py] == 7 && matOrgin[qx][qy] == 7)
            ) count++;
            else if ((matOrgin[px][py] == 6 && matOrgin[qx][qy] != 9) || 
                (matOrgin[px][py] == 9 && matOrgin[qx][qy] != 6) || 
                (matOrgin[px][py] == 7) ||
                (matOrgin[px][py] == 8 && matOrgin[qx][qy] != 8)
            ) {
                System.out.println(-1);
                return;
            }

            py++;
            qy--;

            if (py == m) {
                px++;
                py=0;
            }

            if (qy == -1) {
                qx--;
                qy=m-1;
            }
        }


        System.out.println(count);
        
    }
}