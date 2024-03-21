import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	static int count, map[][], N, num[], cnt;
	static boolean visited[][];
	static int [] dc = {-1, 0, 1, 0};
	static int [] dr = {0, 1, 0, -1};
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean [N+2][N+2];
		map = new int [N+2][N+2];
		for(int i = 1; i<N+1; i++) {
			String str = br.readLine();
			for(int j = 1; j<N+1; j++) {
				map[i][j] = str.charAt(j-1)-'0';
			}
		}
		
		for(int i = 1; i<N+1; i++) {
			for(int j = 1; j<N+1; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					visited[i][j] = true;
					count = 1;
					search(i,j);
					pq.offer(count);
				} 
			}
		}
		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		
	}

	private static void search(int c, int r) {
		for(int i = 0; i<4; i++) {
			int C = c + dc[i];
			int R = r + dr[i];
			
			if(!visited[C][R] && map[C][R] == 1) {
				visited[C][R] = true;
				count++;
				search(C,R);
			}
		}
	}
}