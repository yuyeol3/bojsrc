import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        boolean asc, desc;
        asc = true; desc = true;
        
        int prev = Integer.parseInt(st.nextToken());
        for (int i = 1; i < 8; i++) {
            int cur = Integer.parseInt(st.nextToken());
            asc = asc && (cur > prev);
            desc = desc && (cur < prev);
            prev = cur;
        }
        
        if (asc) bw.write("ascending\n");
        else if (desc) bw.write("descending\n");
        else bw.write("mixed");
        bw.flush();
    }
}