import java.io.*;

class Pr2448 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private final int[][] dp;
    private final int num;
    public Pr2448(int n) {
        num = n;
        dp = new int[num][num*2-1];
        putStar(n, 0, 0);
    }

    public void print() throws IOException {

        for (int i = 0; i < num; ++ i) {
            for (int j = 0; j < num*2-1; ++j) {
                bw.write(dp[i][j] == 0 ? ' ' : '*');
            }
            bw.write('\n');
        }

    }
    private void putStar(int n, int stRow, int stCol) {
        if (n == 3) {
//            System.out.println(stCol);
            dp[stRow][stCol+2] = 1;
            dp[stRow+1][stCol+1] = 1;
            dp[stRow+1][stCol+3] = 1;


            for (int i = 0; i < 5; ++i) {

                dp[stRow + 2][stCol + i] = 1;
            }
            return;
        }
        putStar(n/2, stRow, stCol + (n - 1) - (n/2 - 1));
        putStar(n/2, stRow + (n/2) ,stCol);
        putStar(n/2, stRow + (n/2),stCol + n);
    }

    public void closeBw() throws IOException {
        bw.flush();
        bw.close();
    }
}


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pr2448 p = new Pr2448(n);
        p.print();

        p.closeBw();
        br.close();

    }
}