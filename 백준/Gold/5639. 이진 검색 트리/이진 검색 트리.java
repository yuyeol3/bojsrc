import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int NODE_MAX = 10005;
    static int[] node = new int[NODE_MAX];
    static int[] left = new int[NODE_MAX];
    static int[] right = new int[NODE_MAX];
    static int root = 1;
    static int free_node = 1;
    
    static void addTree(int x) {
        if (root == free_node) {
            node[free_node++] = x;
            return;
        }
        int next = root;
        int prev = 0;
        while (true) {
            prev = next;
            if (node[next] < x) {
                next = right[next];
                if (next == 0) {
                    node[free_node++] = x;
                    right[prev] = free_node-1;
                    return;
                }
            }
            else if (node[next] > x) {
                next = left[next];
                if (next == 0) {
                    node[free_node++] = x;
                    left[prev] = free_node-1;
                    return;
                }
            }
        }
    }

    static void postOrder(int x) {
        if (x == 0) return;
        postOrder(left[x]);
        postOrder(right[x]);
        sb.append(node[x]).append("\n");
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            String numStr = br.readLine();
            if (numStr == null) break;
            addTree(Integer.parseInt(numStr));
        }
        postOrder(root);
        System.out.print(sb);
    }
}