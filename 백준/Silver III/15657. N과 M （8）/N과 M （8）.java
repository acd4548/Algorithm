import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, arr[], used[];
	static boolean visited[];
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean [N];
		arr = new int [N];
		used = new int [M];
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		check(0,0);
		System.out.println(sb);
	}
	
	public static void check(int idx, int uidx) {
		if(uidx == M) {
			for(int i = 0; i<M; i++) {
				sb.append(used[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = idx; i<N; i++) {
			used[uidx] = arr[i];
			check(i, uidx+1);
		}
		
		
	}
}