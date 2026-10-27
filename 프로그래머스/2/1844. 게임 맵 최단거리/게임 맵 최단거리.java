import java.util.*;

class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        
        
        if (maps[0][0] == 0 || maps[n-1][m-1] == 0)
            return -1;
    
        
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
        }
        
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[]{0, 0});
        visited[0][0] = 1;
        // return -1;
        
    
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int x = cur[0], y = cur[1];
            
            if (x == n-1 && y == m-1) break;
            
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny] != -1 || maps[nx][ny] == 0) continue;
                
                q.offerLast(new int[]{nx, ny});
                visited[nx][ny] = visited[x][y] + 1;
            }   
        }
        
        return visited[n-1][m-1];
    }
}