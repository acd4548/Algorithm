import java.util.Scanner;

public class Main{
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int [][] arr = new int [100][100];
		
		for(int i = 0; i<N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			for(int j = a; j<a+10; j++) {
				for(int q = b; q<b+10; q++) {
					arr[j][q] = 1;
				}
			}
		}
		
		int count = 0;
		for(int i = 0; i<100; i++) {
			for(int j = 0; j<100; j++) {
				if(arr[i][j] == 1) {
					count += 1;
				}
			}
		}
		
		System.out.println(count);
		
	}
}