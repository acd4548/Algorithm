import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	
	static int N, M, map[][], visited[][], min, flag;
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		visited = new int [N][M];
		min = Integer.MAX_VALUE;
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			for(int j = 0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		flag = -1;
		bfs(new int[] {0,0,0,0});
		
		if(flag == 1) {
			System.out.println(min);
		}else
			System.out.println(-1);
		
	}
	// 배열{ r값, c값, count, 내 상태 }	// 내 상태는 0(벽을 부순적 없음) 1(벽을 부순적 있음)
	// visited 0은 미방문자리, 1은 방문 + 벽부순적 x, 2는 방문 + 벽부순적o
	private static void bfs(int[] a) {
		Queue<int[]> q = new LinkedList<>();
		visited[a[0]][a[1]] = 1;
		a[2]++;
		q.offer(a);
		
		while(!q.isEmpty()) {
			int [] A = q.poll();
			
			if(A[0] == N-1 && A[1] == M-1) {
				if(A[2] < min) {
					min = A[2];
					flag = 1;
				}
			}
			
			for(int i = 0; i<4; i++) {
				int R = A[0] + dr[i];
				int C = A[1] + dc[i];
				
				if(R < 0 || R >= N || C < 0 || C >= M) continue;
				
				if(A[3] == 0) {							//내 상태 (벽 부순적 없는 경우)
					if(visited[R][C] == 0) {			//다음칸의 방문 상태 (미방문)
						if(map[R][C] == 0) {			//다음칸 구조 (빈곳)
							visited[R][C] = 1;
							q.offer(new int[] {R,C,A[2]+1,0});
						}else if(map[R][C] == 1) {		//다음칸 구조 (벽)
							visited[R][C] = 2;
							q.offer(new int[] {R,C,A[2]+1,1});
						}
					}else if(visited[R][C] == 1) {		//다음칸의 방문 상태 (방문but벽부순적x)
						if(map[R][C] == 0) {			//다음칸 구조 (빈곳)
							continue;
						}else if(map[R][C] == 1) {		//다음칸 구조 (벽)
							continue;//흠.
						}
					}else if(visited[R][C] == 2) {		//다음칸의 방문 상태 (방문and벽부순적o)
						if(map[R][C] == 0) {			//다음칸 구조 (빈곳)
							visited[R][C] = 1;
							q.offer(new int[] {R,C,A[2]+1,0});
						}else if(map[R][C] == 1) {		//다음칸 구조 (벽)
							visited[R][C] = 2;
							q.offer(new int[] {R,C,A[2]+1,1});
						}
					}
				}else if(A[3] == 1) {					//내 상태 (벽 부순적 있는 경우)
					if(visited[R][C] == 0) {			//다음칸의 방문 상태 (미방문)
						if(map[R][C] == 0) {			//다음칸 구조 (빈곳)
							visited[R][C] = 2;
							q.offer(new int[] {R,C,A[2]+1,1});
						}else if(map[R][C] == 1) {		//다음칸 구조 (벽)
							continue;
						}
					}else if(visited[R][C] == 1) {		//다음칸의 방문 상태 (방문but벽부순적x)
						if(map[R][C] == 0) {			//다음칸 구조 (빈곳)
							continue;
						}else if(map[R][C] == 1) {		//다음칸 구조 (벽)
							continue;
						}
					}else if(visited[R][C] == 2) {		//다음칸의 방문 상태 (방문and벽부순적o)
						if(map[R][C] == 0) {			//다음칸 구조 (빈곳)
							continue;
						}else if(map[R][C] == 1) {		//다음칸 구조 (벽)
							continue;
						}
					}
				}
			}
		}
	}
}