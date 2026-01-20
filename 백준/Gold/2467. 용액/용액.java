import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long[] sols = new long[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) 
            sols[i] = Long.parseLong(st.nextToken());
        
        int leftPtr = 0;
        int rightPtr = N-1;
        long minDist;
        int minLeft, minRight;
        minLeft = leftPtr;
        minRight = rightPtr;
        minDist = Math.abs(sols[leftPtr] + sols[rightPtr]);

        while (leftPtr < rightPtr) {
            long curDist = sols[leftPtr] + sols[rightPtr];

            if (minDist > Math.abs(curDist)) {
                minDist = Math.abs(curDist);
                minLeft = leftPtr;
                minRight = rightPtr;
            }

            if (curDist > 0) rightPtr--;
            else if (curDist < 0) leftPtr++;
            else break;
        }

        System.out.println(sols[minLeft] + " " + sols[minRight]);

    }
}