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

		for(int i = 1; i<50; i++){
			for(int j = 1; j<50; j++){
				for(int k = 1; k<50; k++){
					if(( i * A ) + ( j * B ) + ( k * C ) == N){
						System.out.println(1);
						return;
					}
				}
			}
		}

		System.out.println(0);
	}
}