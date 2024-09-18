import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n-1; ++i) {
            int starNum = i + 1;
            int blankNum = n * 2 - ((i+1) * 2);
            for (int j = 0; j < starNum; ++j) {
                System.out.printf("*");
            }

            for (int j = 0; j < blankNum; ++j) {
                System.out.printf(" ");
            }

            for (int j = 0; j < starNum; ++j) {
                System.out.printf("*");
            }
            System.out.printf("\n");
        }


        for (int i = n - 1; i >= 0; --i) {
            int starNum = i + 1;
            int blankNum = n * 2 - ((i+1) * 2);
            for (int j = 0; j < starNum; ++j) {
                System.out.printf("*");
            }

            for (int j = 0; j < blankNum; ++j) {
                System.out.printf(" ");
            }

            for (int j = 0; j < starNum; ++j) {
                System.out.printf("*");
            }
            System.out.printf("\n");
        }

    }
}
