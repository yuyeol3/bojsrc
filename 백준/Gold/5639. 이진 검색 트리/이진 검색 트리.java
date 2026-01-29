import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int MAX_NODE = 10005;
    static StringBuilder sb = new StringBuilder();
    static class Node {
        int left = 0;
        int right = 0;
    }

    public static void main(String[] args) throws IOException {

        Map<Integer, Node> tree = new HashMap<>();
        Deque<Integer> stk = new ArrayDeque<>();

        int root = Integer.parseInt(br.readLine());
        tree.put(root, new Node());
        stk.addFirst(root);
        while (true) {
            String numStr = br.readLine();
            if (numStr == null) break;
            int num = Integer.parseInt(numStr);
            if (num < stk.peek()) {
                tree.get(stk.peek()).left = num;
                tree.put(num, new Node());
                stk.addFirst(num);
            }
            else {
                int parent = stk.pollFirst();
                while (!stk.isEmpty() && num > stk.peek()) {
                    parent = stk.pollFirst();
                }
                tree.get(parent).right = num;
                tree.put(num, new Node());
                // stk.addFirst(parent);
                stk.addFirst(num);
            }
        }
        postOrder(root, tree);
        System.out.print(sb);
    }
 
    static void postOrder(int nodeNum, final Map<Integer, Node> tree) {
        // if (nodeNum == 0) return;
        Node node = tree.get(nodeNum);
        if (node.left != 0) postOrder(node.left, tree);
        if (node.right != 0) postOrder(node.right, tree);
        sb.append(nodeNum).append("\n");
    }
}