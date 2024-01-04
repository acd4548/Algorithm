import java.util.*;
import java.io.*;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 여학생의 수
		int M = Integer.parseInt(st.nextToken()); // 남학생의 수
		int K = Integer.parseInt(st.nextToken()); // 인턴쉽에 참여해야하는 인원
		int cnt = 0;

		// 인턴쉽에 참여해야하는 인원만큼 남 또는 여학생의 수에서 빼고
		// 남은 학생의 수 중 여2 남1의 조합으로 팀을 구린 걸 세서 제출 !
		
		while(K > 0){ // 인턴쉽에 나가는 학생 수가 0이될 때까지
			if((M * 2) < N){ // 남학생의 2배보다 여학생이 많다면
				N--; // 여학생과 인턴쉽에 나가는 학생 수를 1씩 줄이기
				K--;
			}else if((M * 2) >= N){ // 남학생의 2배가 여학생과 같거나 크다면
				M--; // 남학생과 인턴쉽에 나가는 학생 수를 1씩 줄이기
				K--;
			}
		}

		while(true){ // 남학생이나 여학생의 수가 최소인원이 안될 때까지 팀수를 구한다.
			if(N <= 1 || M <= 0){
				break;
			}
			N -= 2;
			M -= 1;
			cnt++;
		}

		System.out.println(cnt);
	}
}