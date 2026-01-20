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
        
        Arrays.sort(sols, 0, N);

        int leftPtr = 0;
        int rightPtr = N-1;
        
        long minPh = Math.abs(sols[leftPtr] + sols[rightPtr]);
        int minLeft = leftPtr;
        int minRight = rightPtr;

        while (leftPtr < rightPtr) {
            long curPh = sols[leftPtr] + sols[rightPtr];

            if (minPh > Math.abs(curPh)) {
                minPh = Math.abs(curPh);
                minLeft = leftPtr;
                minRight = rightPtr;
            }

            if (curPh > 0) rightPtr--;
            else if (curPh < 0) leftPtr++;
            else break;
        }

        System.out.println(sols[minLeft] + " " + sols[minRight]);

    }
}