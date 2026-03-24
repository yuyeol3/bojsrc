import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
       boolean[] arr = new boolean[31];
    
       for (int i = 1; i <= 28; i++) {
            arr[Integer.parseInt(br.readLine())] = true;
       }

       StringBuilder sb = new StringBuilder();
       for (int i = 1; i <= 30; i++) {
            if (!arr[i]) sb.append(i).append("\n");
       }
       System.out.print(sb);
    }
}