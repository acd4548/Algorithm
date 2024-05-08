import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, map[][], temp[][];
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};
	static boolean visited[][];
	
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		temp = new int [N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = map[i][j];
				
			}
		}
		
		int temp1 = map[1][1];
		boolean flag = false; // true가 정상 false 면 stop
		for(int i = 1; i<N-1; i++) {
			for(int j = 1; j<M-1; j++) {
				if(temp1 != map[i][j]) {
					flag = true;
				}
			}
		}
		
		if(flag == false) {
			System.out.println(0);
			return;
		}
		
		
		int ans = 0;
		int count = 1;
		while(count == 1) {
			scan();
			count = check();
			ans++;
//			for(int i = 0; i<N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
		}
		
		System.out.println(ans);
		
		
		
		
	}
	
	private static int check() {
		int count = 0;
		visited = new boolean[N][M];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(!visited[i][j] && map[i][j] != 0) {
					count++;
					bfs(i,j);
				}
			}
		}
		return count;
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int [] {r,c});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int [] a = q.poll();
			
			for(int i = 0; i<4; i++) {
				int R = a[0] + dr[i];
				int C = a[1] + dc[i];
				
				if(map[R][C] != 0 && !visited[R][C]) {
					visited[R][C] = true;
					q.offer(new int [] {R,C});
				}
			}
		}
	}

	static void scan() {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] != 0) {
					int cnt = 0;
					for(int k = 0; k<4; k++) {
						int R = i + dr[k];
						int C = j + dc[k];
						
						if(map[R][C] == 0) {
							cnt++;
						}
					}
					
					if((temp[i][j] - cnt) >= 0) {
						temp[i][j] -= cnt;
					}else {
						temp[i][j] = 0;
					}
					
				}
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}
}