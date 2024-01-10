import java.util.*;
import java.io.*;

public class Main {
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		//처음부터 나보다 큰애 만날때까지 칸 * 나의 높이
		//젤큰애를 구했다 ?
		// 맨뒤부터 젤큰애까지도 한번더 해주기
		int N = Integer.parseInt(br.readLine());
		int [][] info = new int [N][2];
		int startX = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
		for(int i = 0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<2; j++){
				info[i][j] = Integer.parseInt(st.nextToken());
			}
			if(info[i][0] < startX) startX = info[i][0];
			if(info[i][1] > maxY) {
				maxY = info[i][1];
			}
		}

		Arrays.sort(info, Comparator.comparing(a -> a[0]));

		//정렬까지만 한 상태 가면서 앞으로 넓이만큼씩 더해주는거 필요
		// 예시 ) (2 * 4) + (4 * 6) + (1 * 10) + (7 * 8) 이런느낌

		//모두 높이가 같을 때 ( 최고높이와 시작높이와 끝높이가 )
		if((info[0][1] == maxY) && info[N-1][1] == maxY){
			ans += maxY * (info[N-1][0] - info[0][0] + 1);
			System.out.println(ans);
			return;
		}

		int signalIdx = 0;
		for(int i = 0; i<N; i++){

			if(info[signalIdx][1] <= info[i][1]){
				ans += (info[i][0] - info[signalIdx][0]) * info[signalIdx][1];
				signalIdx = i;
			}
		}
		signalIdx = N-1;
		for(int i = signalIdx; i>=0; i--){

			if(info[signalIdx][1] < info[i][1]){
				ans += (info[signalIdx][0]- info[i][0]) * info[signalIdx][1];
				signalIdx = i;
			}
		}

		ans += maxY;

		System.out.println(ans);
	}
}