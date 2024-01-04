import java.util.*;
import java.io.*;

public class Main {
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()); // 양의 사료 량
		int b = Integer.parseInt(st.nextToken()); // 염소의 사료 량
		int n = Integer.parseInt(st.nextToken()); // 전체 마리 수
		int w = Integer.parseInt(st.nextToken()); // 하루 소비 사료 양

		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for(int i = 1; i<=1000; i++){
			for(int j = 1; j<=1000; j++){
				if(((a * i) + (b * j)) == w && (i + j == n)){
					sb.append(i).append(" ").append(j);
					cnt++;
				}
			}
		}

		if(cnt == 1){
			System.out.println(sb);
		}else{
			System.out.println(-1);
		}
	}
}