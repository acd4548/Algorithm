import java.util.*;
import java.io.*;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int cnt = 0;
		for(int i = 1; i<N; i++){ // 택희
			for(int j = 1; j<N; j++){ // 영훈
				for(int k = 1; k<N; k++){ // 남규
					if(i + j + k != N) continue;

					if(k < j + 2) continue;

					if(i % 2 == 1) continue;

					cnt++;
				}
			}
		}
		System.out.println(cnt);


	}
}