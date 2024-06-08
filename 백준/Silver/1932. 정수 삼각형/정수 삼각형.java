import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[n][n];
        int max = 1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < max; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            max++;
        }

        max -= 2;
        for(int i = n-2; i>=0; i--){
            for(int j = 0; j<max; j++){
                arr[i][j] = Math.max(arr[i][j] + arr[i+1][j], arr[i][j] + arr[i+1][j+1]);
            }
            max--;
        }
        System.out.println(arr[0][0]);
    }
}