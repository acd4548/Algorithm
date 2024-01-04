import java.io.*;
import java.util.*;

public class Main {
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int [9]; // 전체 숫자를 담아주고
		int sum = 0;	//모든 키를 더해줄 숫자
		for(int i = 0; i<9; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken()); //입력받아주기
			sum += arr[i]; // 모든 키 더해주기
		}
		int dif = sum - 100; // 더한 키 - 100 = 7난쟁이뺴고 2명의 키 합
		Arrays.sort(arr); // 오름차순 미리 해주고

		int [] ans = new int [2]; // 2명의 idx 받아줄 배열
		for(int i = 0; i<8; i++){ // 완탐돌면서 2명 찾아주고
			for(int j = i+1; j<9; j++){
				if(arr[i] + arr[j] == dif){
					ans[0] = i; // 2명의 idx를 기록해준다.
					ans[1] = j;
				}
			}
		}

		for(int i = 0; i<9; i++){
			if(i == ans[0] || i == ans[1]) continue; // 2명빼고 출력
			System.out.println(arr[i]);
		}
	}
}