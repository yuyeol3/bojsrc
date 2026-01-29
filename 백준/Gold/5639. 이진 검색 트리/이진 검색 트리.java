import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static class Node {
        Node left = null;
        Node right = null;
        int num;
        public Node(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {

        Deque<Node> stk = new ArrayDeque<>();
        int root = Integer.parseInt(br.readLine());
        Node tree = new Node(root);
        stk.addFirst(tree);
        while (true) {
            String numStr = br.readLine();
            if (numStr == null) break;
            int num = Integer.parseInt(numStr);
            if (num < stk.peek().num) {
                stk.peek().left = new Node(num);
                stk.addFirst(stk.peek().left);
            }
            else {
                Node parent = stk.pollFirst();
                while (!stk.isEmpty() && num > stk.peek().num) {
                    parent = stk.pollFirst();
                }
                parent.right = new Node(num);
                stk.addFirst(parent.right);
            }
        }

        Deque<Node> stk2 = new ArrayDeque<>();
        stk2.add(tree);
        
        while (!stk2.isEmpty()) {
            Node s = stk2.peek();
            if (s.left == null && s.right == null) {
                sb.append(s.num).append("\n");
                stk2.pollFirst();
                continue;
            }

            if (s.left != null) {
                stk2.addFirst(s.left);
                s.left = null;
            }
            else if (s.right != null) {
                stk2.addFirst(s.right);
                s.right = null;
            }
        }
        System.out.print(sb);
    }
}