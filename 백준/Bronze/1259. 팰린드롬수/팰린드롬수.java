import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        while (true) {
            String s = br.readLine();
            if (s.equals("0")) break;
            
            int N = s.length();
            String result = "yes";
            for (int i = 0; i < N / 2; i++) {
                if (s.charAt(i) != s.charAt(N-i-1)) {
                    result = "no";
                    break;
                }
            }
            bw.write(result + "\n");
        }
        bw.flush();
    }
}