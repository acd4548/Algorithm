import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
	static int map[][], N, M, count;
	static int dc[] = {-1, 0, 1, 0};
	static int dr[] = {0, 1, 0, -1};
	static boolean visited[][];
	static Queue<int[]> q1 = new LinkedList<>();
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	M = Integer.parseInt(st.nextToken());
    	N = Integer.parseInt(st.nextToken());
    	count = 0;
    	map = new int [N][M];
    	visited = new boolean [N][M];
    	
    	int ifzero = 0;
    	for(int i = 0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j<M; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			if ( map[i][j] == 0) {
    				ifzero++;
    			}else if(map[i][j] == 1) {
    				int [] a = {i,j};
    				q1.offer(a);
    				visited[i][j] = true;
    			}
    		}
    	}
    	if(ifzero == 0) {
    		System.out.println(0);
    		return;
    	}
    	
    	check();
    	for(int i = 0; i<N; i++) {
    		for(int j = 0; j<M; j++) {
    			if(map[i][j] == 0) {
    				System.out.println(-1);
    				return;
				}
			}
		}
    	System.out.println(count-1);
    	}
	
    private static void check() {
    	
    	Queue<int[]> q2 = new LinkedList<>();
    	while(!q1.isEmpty()) {
    		int [] a = q1.poll();
    		for(int i = 0; i<4; i++) {
    			int C = a[0] + dc[i];
    			int R = a[1] + dr[i];
    			
    			if(C >= 0 && C < N && R >= 0 && R < M && map[C][R] == 0 && !visited[C][R]) {
    				map[C][R] = 1;
    				int [] b = {C,R};
    				q2.offer(b);
    				visited[C][R] = true;
    			}
    		}
    		
    		if(q1.isEmpty()) {
    			q1 = q2;
    			q2 = new LinkedList<>();
    			count++;
    		}
    	}
    }
}