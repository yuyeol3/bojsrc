import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        boolean[] isSquare = new boolean[n+1];
        int[] squares = new int[n+1];
        int sidx = 0;
        
        // O(\sqrt n)
        for (int i = 1; i * i <= n; i++) {
            isSquare[i*i] = true;
            squares[sidx++] = i*i;
            // System.out.println(i*i);
        }

        if (isSquare[n]) {
            System.out.println(1);
            return;    
        }


        // O(\log n)
        int num = n;
        while (num % 4 == 0) {
            num /= 4;
        }
        if ((num-7) % 8 == 0) {
            System.out.println(4);
            return;
        }
        
        // O(\sqrt n)
        for (int i = sidx-1; i >= 0; i--) {
            if (isSquare[n-squares[i]]) {
                System.out.println(2);
                return;
            }
        }

        System.out.println(3);

    }

}