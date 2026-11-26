import java.util.*;

class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public int solution(int[][] land) {
        int N = land.length;
        int M = land[0].length;
        
        int nid = 1;
        int[] counts = new int[N*M+1];
        int[][] idMap = new int[N][M];
        
        // O(N^2)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (land[i][j] == 1 && idMap[i][j] == 0) {
                    
                    Deque<int[]> q = new ArrayDeque<>();
                    q.offerLast(new int[]{i, j});
                    int id = nid++;
                    idMap[i][j] = id;
                    while (!q.isEmpty()) {
                        int[] xy = q.pollFirst();
                        int x = xy[0], y = xy[1];
                        counts[id]++;
                        
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = x + dx[dir];
                            int ny = y + dy[dir];
                            
                            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                            if (land[nx][ny] == 0 || idMap[nx][ny] != 0) continue;
                            
                            idMap[nx][ny] = idMap[x][y];
                            q.offerLast(new int[]{nx, ny});
                        }
                    }
                    
                }
            }
        }
        
        
        int maxOil = 0;
        // O(N^3)
        for (int i = 0; i < M; i++) {
            int totOil = 0;
            Set<Integer> ids = new HashSet<>();
            
            for (int j = 0; j < N; j++) {
                if (idMap[j][i] != 0)
                    ids.add(idMap[j][i]);
            }
            
            for (int id : ids) {
                totOil += counts[id];
            }
            
            maxOil = Math.max(maxOil, totOil);
        }
        
        return maxOil;
    }
}