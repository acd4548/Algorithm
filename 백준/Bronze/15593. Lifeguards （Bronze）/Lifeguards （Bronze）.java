import java.util.*;
import java.io.*;

public class Main {
	public static void main (String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		//사람들 써서 최대한의 많은 타임을 커버할수 있게..
		//1번쨰 사람부터 마지막 사람까지 한명씩 하나빼고 다세보고 하나빼고 다세보고
		int [][] timetable = new int [N][2];
		for(int i = 0 ; i<N; i++){
			st = new StringTokenizer(br.readLine());
			timetable[i][0] = Integer.parseInt(st.nextToken());
			timetable[i][1] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		for(int i = 0; i<N; i++){ // idx 가 i인거 제외하고 세보기
			int [] map = new int [1001];
			for(int j = 0; j<N; j++){
				if(i == j) continue;
				for(int k = timetable[j][0]; k<timetable[j][1]; k++){
					map[k] = 1;
				}
			}
			int sum = 0;
			for(int j = 0; j<1001; j++){
				sum += map[j];
			}
			if(sum > max){
				max = sum;
			}
		}

		System.out.println(max);


	}
}