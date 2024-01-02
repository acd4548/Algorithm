import java.util.*;
import java.io.*;

public class Main {
	public static int N, M, used[], arr[];
	public static boolean visited[];
	public static void main (String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean [N];
		used = new int [N];
		arr = new int [N];

		for(int i = 0; i<N; i++){
			arr[i] = i+1;
		}

		check(0);
	}

	public static void check(int idx){
		if( idx == M ){
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i<M; i++){
				sb.append(used[i]).append(" ");
			}
			System.out.println(sb);
			return;
		}

		for(int i = 0; i<N; i++){
			if(visited[i]) continue;
			used[idx] = arr[i];
			visited[i] = true;
			check(idx+1);
			visited[i] = false;
		}

	}
}