import java.util.*;
import java.io.*;

public class Main {
	public static void main (String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int [][] info = new int [N][3];
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int k = 0; k<3; k++){
				info[i][k] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0;
		for(int i = 1; i<=9; i++){
			for(int j = 1; j<=9; j++){
				if(j == i) continue;
				for(int k = 1; k<=9; k++){
					if(k == i || k == j) continue;
					int cnt = 0;
					for(int z = 0; z<N; z++){
						//여기서 이제 각 N개의 케이스와 3자리숫자와 비교해서
						//모든 N개의 케이스에 따른 S개수 B개수가 같다면 cnt++;
						int s = 0;
						int b = 0;

						int h = info[z][0] / 100;
						int t = info[z][0] / 10 % 10;
						int o = info[z][0] % 10;

						if(i == h) s++;
						if(j == t) s++;
						if(k == o) s++;

						if(s != info[z][1]) break;

						if(i == t || i == o) b++;
						if(j == h || j == o) b++;
						if(k == h || k == t) b++;

						if(b != info[z][2]) break;

						cnt++;
					}
					if(cnt == N) ans++;
				}
			}
		}
		System.out.println(ans);
	}
}