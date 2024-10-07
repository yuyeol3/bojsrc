import java.io.*;
import java.util.Scanner;

public class Main {
    public static char[][] arr;
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = scanner.nextInt();
        arr = new char[N][N];
        printStar(N, 0, 0);

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                bw.write(arr[i][j] == (char) 0 ? " ": "*");
            }
            bw.write("\n");
        }
        scanner.close();
        bw.flush();
        bw.close();
    }

    public static void printStar(int n, int st_row, int st_col) {
        if (n == 1) {
            arr[st_row][st_col] = '*';
            return;
        }

        int split_size = n / 3;
        int split_num  = n / split_size;

        for (int r = 0; r < split_num; ++r) {
            for (int c = 0; c < split_num; ++c) {
                if (r != 1 || c != 1)
                    printStar(
                            split_size,
                            st_row + r *split_size,
                            st_col + c * split_size
                    );
            }
        }
    }

}
