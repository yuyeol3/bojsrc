
import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	
	
	static int maxCores;
	static int minWires;
	static int N;
	static List<int[]> cores;
	static List<int[]> disconnecteds;
	static int[][] maps;
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static void dfs(int step, int wireLength, int cores) {
		if (cores + (disconnecteds.size() - step) < maxCores) return;
		
		if (step == disconnecteds.size()) {
			if (cores > maxCores || (cores == maxCores && wireLength < minWires) ) {
				maxCores = cores;
				minWires = wireLength;
			}
			return;
		}
		
		for (int dir = 0; dir < 4; dir++) {
			int[] core = disconnecteds.get(step);
			int x = core[0];
			int y = core[1];
			int dist = 0;
			boolean valid = true;
			while (true) {
				x += dx[dir];
				y += dy[dir];
				
				if (x < 0 || x >= N || y < 0 || y >= N) break;
				if (maps[x][y] != 0) {
					valid = false;
					break;
				}
				
				dist++;
			}
			
			if (!valid) continue;
			x = core[0];
			y = core[1];
			while (true) {
				x += dx[dir];
				y += dy[dir];
				
				if (x < 0 || x >= N || y < 0 || y >= N) break;
				maps[x][y] = 1;
			}
			dfs(step + 1, wireLength + dist, cores + 1);
			while (true) {
				x -= dx[dir];
				y -= dy[dir];
				
				if (x == core[0] && y == core[1]) break;
				maps[x][y] = 0;
			}
			
		}
		// 이 코어를 선택하지 않음
		dfs(step + 1, wireLength, cores);
		
	}
	
	static void init() {
		maxCores = 0;
		minWires = 2000;
		cores = new ArrayList<>();
		disconnecteds = new ArrayList<>();
	}
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			init();
			N = Integer.parseInt(br.readLine());
			maps = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					maps[i][j] = Integer.parseInt(st.nextToken());
					if (maps[i][j] == 1) {
						cores.add(new int[] {i,j});
					}
					
				}
			}
			
			for (int[] core : cores) {
				int x = core[0];
				int y = core[1];
				
				if (x == 0 || x == N-1 || y == 0 || y == N-1)
					continue;
				
				disconnecteds.add(core);
			}
			dfs(0, 0, 0);
			sb.append("#").append(t+1).append(" ").append(minWires).append("\n");
		}
		System.out.print(sb);
	}
	
}