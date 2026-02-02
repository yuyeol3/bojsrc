import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());

        while (M-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken().stripTrailing();
            // System.out.println("cmd=" + cmd);
            if (cmd.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                set.add(x);
            }
            else if (cmd.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                set.remove(x);
            }
            else if (cmd.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                sb.append(set.contains(x) ? 1 : 0).append("\n");
            }
            else if (cmd.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                if (set.contains(x)) set.remove(x);
                else set.add(x);
                
            }
            else if (cmd.equals("all")) {
                for (int i = 1; i <= 20; i++) {
                    if (!set.contains(i))
                        set.add(i);
                }
            }
            else if (cmd.equals("empty")) {
                set.clear();
            }
        }
        System.out.print(sb);
    }
}