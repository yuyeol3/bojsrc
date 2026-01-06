import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
           
        int result = 0;
        for (int i = 0; i < 5; i++) {
            int n = Integer.parseInt(st.nextToken());
            result = (result + n * n) % 10;
        }
        bw.write(result + "\n");
        bw.flush();
    }
}