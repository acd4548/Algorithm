import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, real[], menu[];
	
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		menu = new int [N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			menu[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		real = new int [M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			real[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(menu);
		
		for(int i = 0; i<M; i++) {
			System.out.print(check(real[i])+" ");
		}
	}

	private static int check(int a) {
		int st = 0;
		int ed = N-1;
		int mid = N/2;
		
		while(true) {
			if(st > ed) {
				return 0;
			}else if(a < menu[mid]) {
				ed = mid-1;
				mid = (st + ed)/2;
			}else if(menu[mid] == a){
				return 1;
			}else if(a > menu[mid]) {
				st = mid+1;
				mid = (st + ed)/2;
			}else if(st == ed) {
				return 1;
			}
		}
	}
}