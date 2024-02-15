import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, arr[], used[];
	static boolean visited[];
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean [N];
		arr = new int [N];
		used = new int [M];
		for(int i = 0; i<N; i++) {
			arr[i] = i+1;
		}
		
		check(0, 0);
	}
	
	public static void check(int idx, int uidx) {
		if(uidx == M) {
			for(int i = 0; i<M; i++) {
				System.out.print(used[i]+" ");
			}
			System.out.println();
			return;
		}
		if(idx == N)
			return;
		
		if(!visited[idx]) {
			visited[idx] = true;
			used[uidx] = arr[idx];
			check(idx+1, uidx+1);
			visited[idx] = false;
			check(idx+1, uidx);
		}
	}
}