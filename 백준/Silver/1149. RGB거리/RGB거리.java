import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int map [][] = new int [N][3];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int dp [][] = new int [N][3];
		dp[0][0] = map[0][0];
		dp[0][1] = map[0][1];
		dp[0][2] = map[0][2];
		
		for(int i = 1; i<N; i++) {
			int a = Integer.MAX_VALUE;
			int b = Integer.MAX_VALUE;
			int c = Integer.MAX_VALUE;
			
			for(int j = 0; j<3; j++) {
				if(dp[i-1][j] < a && j != 0) {
					a = dp[i-1][j];
				}
			}
			
			dp[i][0] = a += map[i][0];
			
			for(int j = 0; j<3; j++) {
				if(dp[i-1][j] < b && j != 1) {
					b = dp[i-1][j];
				}
			}
			
			dp[i][1] = b += map[i][1];
			
			for(int j = 0; j<3; j++) {
				if(dp[i-1][j] < c && j != 2) {
					c = dp[i-1][j];
				}
			}
			
			dp[i][2] = c += map[i][2];
			
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i<3; i++) {
			if(ans > dp[N-1][i]) {
				ans = dp[N-1][i];
			}
		}
		
		System.out.println(ans);
		
	}
}