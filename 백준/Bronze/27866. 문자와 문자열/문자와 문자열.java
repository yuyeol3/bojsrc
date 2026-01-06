import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        int i = Integer.parseInt(br.readLine());
        
        bw.write(s.charAt(i-1) + "\n");
        bw.flush();
    }
}