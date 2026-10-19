class Solution {
    int[] dx = {1, -1};
    public int solution(int n, int w, int num) {
        
        int h = n / w + (n % w == 0 ? 0 : 1);
        // int[][] board = new int[w+1][h+1];
        
        int x = 0;
        int y = h-1;
        int idx = 1;
        int dir = 0;
        int answer = 0;
        int tX = -1;
        while (idx <= n) {
            if (tX == x) {
                answer++;
            }
            if (idx == num) {
                tX = x;
                answer++;
            }

            idx++;
            x += dx[dir];
            if (x == w || x == -1) {
                x -= dx[dir];
                dir = (dir + 1) % 2;
                y--;
            }
            // IO.println(board);
        }
        
        return answer;
    }
}