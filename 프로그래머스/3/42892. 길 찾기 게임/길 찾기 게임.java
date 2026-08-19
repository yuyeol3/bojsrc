import java.util.*;

class Solution {
    class Node {
        public int x, y, id;
        public Node left, right;
        
        public Node(int x, int y, int id) {
            this.x = x;
            this.y = y;
            this.id = id;
        }
        
    }
    
    void appendNode(Node root, Node toAppend) {
        if (root.x > toAppend.x) {
            if (root.left == null) {
                root.left = toAppend;
            }
            else {
                appendNode(root.left, toAppend);
            }
        }
        if (root.x < toAppend.x) {
            if (root.right == null) {
                root.right = toAppend;
            }
            else {
                appendNode(root.right, toAppend);
            }
        }
    }
    
    void postOrder(Node root, List<Integer> ord) {
        if (root == null) return;
        
        postOrder(root.left, ord);
        postOrder(root.right, ord);
        ord.add(root.id);
    }
    
    void preOrder(Node root, List<Integer> ord) {
        if (root == null) return;
        
        ord.add(root.id);
        preOrder(root.left, ord);
        preOrder(root.right, ord);
    }
    
    public int[][] solution(int[][] nodeinfo) {
        int N = nodeinfo.length;
        int[][] sorted = new int[N][3];
        
        for (int i = 0; i < N; i++) {
            sorted[i][0] = nodeinfo[i][0];
            sorted[i][1] = nodeinfo[i][1];
            sorted[i][2] = i+1;
        }
        
        Arrays.sort(sorted, (a, b)->{
            if (a[1] != b[1])
                return Integer.compare(b[1], a[1]);
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[2], b[2]);
        });
        
        Node graph = new Node(sorted[0][0], sorted[0][1], sorted[0][2]);
        
        for (int i = 1; i < N; i++) {
            appendNode(graph, new Node(sorted[i][0], sorted[i][1], sorted[i][2]));
        }
        
        int[][] answer = new int[2][N];
        
        List<Integer> post = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        preOrder(graph, pre);
        postOrder(graph, post);
        
        for (int i = 0; i < N; i++) {
            answer[0][i] = pre.get(i);
            answer[1][i] = post.get(i);
        }
        
        
        return answer;
    }
}