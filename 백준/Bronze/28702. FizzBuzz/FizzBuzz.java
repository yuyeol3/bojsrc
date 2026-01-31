import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        
        int x,i;
        x = 0;
        for (i = 0; i < 3; i++) {
            String t = br.readLine();
            if (isNumeric(t)) {
                x = Integer.parseInt(t);
                break;
            }
        }

        int next = x + (3 - i);

        if (next % 3 == 0 && next % 5 == 0) {
            System.out.println("FizzBuzz");
        }
        else if (next % 3 == 0) {
            System.out.println("Fizz");
        }
        else if (next % 5 == 0) {
            System.out.println("Buzz");
        }
        else {
            System.out.println(next);
        }
    }

    static boolean isNumeric(String s) {
        return s.charAt(0) - '0' >= 0 && s.charAt(0) - '0' <= 9;
    }
}