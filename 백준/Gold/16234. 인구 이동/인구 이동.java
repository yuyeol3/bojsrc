import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, L, R;
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		int[][] nations = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				nations[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		Deque<int[]> q = new ArrayDeque<>();
		int day = 0;
		while (true) {
			if (popMove(nations, L, R) != 0)
				day++;
			else break;
		}
		System.out.println(day);
		
	}
	
	// 인구이동 발생한 연합 개수 출력
	static int popMove(int[][] nations, int L, int R) {
		int N = nations.length;
		int[][] united = new int[N][N];
		
		Deque<int[]> q = new ArrayDeque<>();
		int idNext = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (united[i][j] != 0) continue;
				int id = idNext++;
				
				q.offerLast(new int[] {i, j});
				united[i][j] = id;
				while (!q.isEmpty()) {
					int[] s = q.pollFirst();
					
					for (int dir = 0; dir < 4; dir++) {
						int nx = s[0] + dx[dir];
						int ny = s[1] + dy[dir];
						
						if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if (united[nx][ny] != 0) continue;
						int diff = Math.abs(nations[s[0]][s[1]] - nations[nx][ny]);
						if (diff < L || diff > R) continue;
						
						
						
						united[nx][ny] = id;
						q.offerLast(new int[] {nx, ny});
						
					}
				}
				
			}
		}
		
		
		int[] sums = new int[idNext];
		int[] nums = new int[idNext];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int id = united[i][j];
				sums[id] += nations[i][j];
				nums[id]++;
			}
		}
		
		int validGroups = 0;
		for (int i = 0; i < idNext; i++) {
			if (nums[i] > 1) validGroups++;
		}
		
		if (validGroups==0) return 0;
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int id = united[i][j];
				if (nums[id] <= 1) continue;
				nations[i][j] = sums[id] / nums[id];
			}
		}
		
		return validGroups;
	}
	
}

