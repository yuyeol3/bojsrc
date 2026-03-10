import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int tz = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int taskNum = Integer.parseInt(st.nextToken());
            int[] taskTime = new int[taskNum];

            
            for (int j = 0; j < taskNum; j++) {
                taskTime[j] = Integer.parseInt(st.nextToken());
            }

            int totTime = 0;
            int maximum = 0;
            int cnt = 0;
            boolean used = false;
            for (; cnt < taskNum; cnt++) {
                if (taskTime[cnt] > maximum) 
                    maximum = taskTime[cnt];

                totTime += taskTime[cnt];
                if (totTime > t && tz < maximum && !used) {
                    totTime -= (maximum - tz);
                    used = true;
                }

                if (totTime > t) break;
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
} 