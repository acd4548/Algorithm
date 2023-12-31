import java.util.*;
import java.io.*;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] num = new int [N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<N+1; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		if(N % 2 == 0) {
			System.out.println(num[N/2]);
		}else {
			System.out.println(num[(N/2)+1]);
		}
	}
}