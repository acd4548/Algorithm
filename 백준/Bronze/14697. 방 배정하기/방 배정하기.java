import java.util.*;
import java.io.*;
public class Main {
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int AMax = (N / A) + 1;
		int BMax = (N / B) + 1;
		int CMax = (N / C) + 1;

		for(int i = 0; i<AMax; i++){
			for(int j = 0; j<BMax; j++){
				for(int k = 0; k<CMax; k++){
					if((A * i) + (B * j) + (C * k) == N){
						System.out.println(1);
						return;
					}
				}
			}
		}
		System.out.println(0);
	}
}