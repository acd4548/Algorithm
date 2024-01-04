import java.util.*;
import java.io.*;
public class Main {
	public static void main(String [] args) throws IOException{
		int [] arr = new int [10]; // 모든 수를 받아줄 배열
		int [] increase = new int [10]; // 증가된 수를 받아놓을 배열
		int sum = 0;
		int idx = 0; // 100이 넘는 순간의 idx

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i<10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken()); // 입력받아주면서
			sum += arr[i]; // 누적으로 합을 구해주고
			increase[i] = sum; // increase 배열에 넣어준다.
			if(increase[i] >= 100) { // 그 값이 100과 같거나 넘었을 때
				idx = i; // idx를 찾아주고 반복문 탈출 !
				break;
			}else{ // 아예 100을 못넘는 경우 !
				idx = i;
			}
		}

		if(increase[idx] == 100){ // idx에 해당하는 수가 딱 100이라면?
			System.out.println(increase[idx]); // 그냥 출력하면 끝!
		} else if (increase[idx] > 100) { // 100보다 크다면?
			// idx의 수와 idx-1의 수 중 100과 누가더 가깝나를 비교
			int dif1 = increase[idx] - 100;
			int dif2 = 100 - increase[idx-1];

			if(dif1 <= dif2){ // idx의 수가 100에 더 가깝거나 차이가 같다면 출력
				System.out.println(increase[idx]);
			}else{
				System.out.println(increase[idx-1]); // 그게 아니라면 idx-1출력
			}
		}else{ // 아예 100을 못넘는 경우 !
			System.out.println(increase[idx]);
		}
	}
}