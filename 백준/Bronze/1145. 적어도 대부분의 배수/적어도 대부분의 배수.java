import java.util.*;
import java.io.*;

public class Main {
	public static void main (String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int [5];
		for(int i = 0; i<5; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 1; i < 1000000; i++){
			int cnt = 0;
			if(i % arr[0] == 0) cnt++;
			if(i % arr[1] == 0) cnt++;
			if(i % arr[2] == 0) cnt++;
			if(i % arr[3] == 0) cnt++;
			if(i % arr[4] == 0) cnt++;

			if(cnt >= 3) {
				System.out.println(i);
				return;
			}
		}
	}
}