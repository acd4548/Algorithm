import java.util.*;
import java.io.*;

public class Main {
	public static void main (String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [][] map = new int [100][100];
		int N = Integer.parseInt(st.nextToken());
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int j = x; j<x+10; j++){
				for(int k = y; k<y+10; k++){
					map[j][k] = 1;
				}
			}
		}

		int ans = 0;
		for(int i = 0; i<100; i++){
			for(int j = 0; j<100; j++){
				ans += map[i][j];
			}
		}

		System.out.println(ans);
	}
}