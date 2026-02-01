import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String isbn = br.readLine().stripTrailing();

        int m = isbn.charAt(isbn.length()-1) - '0';
        int sum = 0;
        int weight = 1;
        for (int i = 0; i < isbn.length()-1; i++) {
            if (isbn.charAt(i) == '*') {
                weight = (i%2==0) ? 1 : 3;
                continue;
            }
            int num = isbn.charAt(i) - '0';
            sum = (sum + (i%2==0 ? num : 3*num))% 10;
        }
        
        for (int i = 0; i < 10; i++) {
            if (m == (10 - (sum + weight * i) % 10)%10) {
                System.out.println(i);
                break;
            }
        }

    }
}