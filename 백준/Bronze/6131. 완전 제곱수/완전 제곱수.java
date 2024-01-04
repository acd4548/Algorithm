import java.util.*;
import java.io.*;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int cnt = 0;
		for(int i = 1; i<=500; i++){ // B
			for(int j = i; j<=500; j++){ // A
				if((i * i) + N == (j * j)){
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}