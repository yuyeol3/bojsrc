import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Map<String, List<String>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String child1 = st.nextToken();
            String child2 = st.nextToken();

            graph.put(parent, List.of(child1, child2));
        }

        preorder("A");
        bw.write("\n");
        inorder("A");
        bw.write("\n");
        postorder("A");
        bw.write("\n");
    
        bw.flush();
        bw.close();
    }   
    
    public static void preorder(String node) throws IOException {
        List<String> children = graph.get(node);
        String childLeft = children.get(0);
        String childRight = children.get(1);
        bw.write(node);
        if (!childLeft.equals(".")) preorder(childLeft);
        if (!childRight.equals(".")) preorder(childRight);
    }

    public static void inorder(String node) throws IOException {
        List<String> children = graph.get(node);
        String childLeft = children.get(0);
        String childRight = children.get(1);
        if (!childLeft.equals(".")) inorder(childLeft);
        bw.write(node);
        if (!childRight.equals(".")) inorder(childRight);
    }

    public static void postorder(String node) throws IOException {
        List<String> children = graph.get(node);
        String childLeft = children.get(0);
        String childRight = children.get(1);
        if (!childLeft.equals(".")) postorder(childLeft);
        if (!childRight.equals(".")) postorder(childRight);
        bw.write(node);
    }
}
