import java.util.*;
import java.io.*;

public class Main {
	public static void main (String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			long key = Long.parseLong(st.nextToken());
			long ans = key;
			for(int j = 2; j<=1000000; j++){
				while(true){
					if(key % j == 0){
						key /= j;
					}else{
						break;
					}
				}
			}
			if(key == ans){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}
}