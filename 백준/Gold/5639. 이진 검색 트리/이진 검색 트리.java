import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int MAX_NODE = 10005;
    static StringBuilder sb = new StringBuilder();
    static class Node {
        int left = 0;
        int right = 0;
        int num;
        public Node(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {

        Map<Integer, Node> tree = new HashMap<>();
        Deque<Integer> stk = new ArrayDeque<>();
        // int N = 0;
        int root = Integer.parseInt(br.readLine());
        tree.put(root, new Node(root));
        stk.addFirst(root);
        while (true) {
            String numStr = br.readLine();
            if (numStr == null) break;
            // N++;
            int num = Integer.parseInt(numStr);
            if (num < stk.peek()) {
                tree.get(stk.peek()).left = num;
                tree.put(num, new Node(num));
                stk.addFirst(num);
            }
            else {
                int parent = stk.pollFirst();
                while (!stk.isEmpty() && num > stk.peek()) {
                    parent = stk.pollFirst();
                }
                tree.get(parent).right = num;
                tree.put(num, new Node(num));
                // stk.addFirst(parent);
                stk.addFirst(num);
            }
        }
        // postOrder(root, tree);

        Deque<Node> stk2 = new ArrayDeque<>();
        stk2.add(tree.get(root));
        
        while (!stk2.isEmpty()) {
            Node s = stk2.peek();
            if (s.left == 0 && s.right == 0) {
                sb.append(s.num).append("\n");
                stk2.pollFirst();
                continue;
            }

            if (s.left != 0) {
                stk2.addFirst(tree.get(s.left));
                s.left = 0;
            }
            else if (s.right != 0) {
                stk2.addFirst(tree.get(s.right));
                s.right = 0;
            }
        }
        

        System.out.print(sb);
    }
}