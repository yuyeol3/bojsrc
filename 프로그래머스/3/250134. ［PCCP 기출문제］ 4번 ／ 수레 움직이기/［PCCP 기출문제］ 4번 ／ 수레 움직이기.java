class Solution {
    
    int answer = 1000;
    int[] bdest;
    int[] rdest;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int N, M;
    
    void f(int bx, int by, int rx, int ry, boolean[][] bvis, boolean[][] rvis, int[][] maze, int count) {
        boolean bfinished = bx == bdest[0] && by == bdest[1];
        boolean rfinished = rx == rdest[0] && ry == rdest[1];
        if (bfinished && rfinished) {
            answer = Math.min(answer, count);
            return;
        }
        
        
        for (int dirr = 0; dirr < (rfinished ? 1 : 4); dirr++) {
            
            int rnx, rny;
            rnx = rny = 0;
            if (rfinished) {
                rnx = rx;
                rny = ry;
            }
            else {
                rnx = rx + dx[dirr];
                rny = ry + dy[dirr];
                if (rnx < 0 || rnx >= N || rny < 0 || rny >= M) continue;
                // if (maze[rnx][rny] == 5 || rvis[rnx][rny] || (rnx == bx && rny == by)) continue;
                if (maze[rnx][rny] == 5 || rvis[rnx][rny]) continue;
                if (bfinished && rnx == bx && rny == by) continue;
            }
            rvis[rnx][rny] = true;
            for (int dirb = 0; dirb < (bfinished ? 1 : 4); dirb++) {
                int bnx, bny;
                bnx = bny = 0;
                if (bfinished) {
                    bnx = bx;
                    bny = by;
                }
                else {
                    bnx = bx + dx[dirb];
                    bny = by + dy[dirb];
                    if (bnx < 0 || bnx >= N || bny < 0 || bny >= M) continue;
                    // if (maze[bnx][bny] == 5 || bvis[bnx][bny] || (bnx == rx && bny == ry) || (bnx == rnx && bny == rny)) continue;
                    if (maze[bnx][bny] == 5 || bvis[bnx][bny] || (bnx == rnx && bny == rny)) continue; 
                    if (rfinished && bnx == rx && bny == ry) continue;
                    if (rnx == bx && rny == by && bnx == rx && bny == ry) continue;
                }
                bvis[bnx][bny] = true;
                f(bnx, bny, rnx, rny, bvis, rvis, maze, count+1);
                bvis[bnx][bny] = false;
            }
            rvis[rnx][rny] = false;
        }
        
    }
    
    public int solution(int[][] maze) {
        N = maze.length;
        M = maze[0].length;
        
        int bx, by, rx, ry;
        bx = by = rx = ry = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int val = maze[i][j];
                if (val == 1) {
                    rx = i; ry = j;
                }
                else if (val == 2) {
                    bx = i; by = j;
                }
                else if (val == 3) {
                    rdest = new int[]{i, j};
                }
                else if (val == 4) {
                    bdest = new int[]{i, j};
                }
                
            }
        }
        
        boolean[][] rvis = new boolean[N][M];
        boolean[][] bvis = new boolean[N][M];
        rvis[rx][ry] = true; bvis[bx][by] = true;
        f(bx, by, rx, ry, bvis, rvis, maze, 0);
        
        
        return answer == 1000 ? 0 : answer;
    }
}