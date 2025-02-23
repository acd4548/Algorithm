import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int [N];
        int t = 0;
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(i == N-1){
                t = arr[i];
            }
        }

        int ans = 1;
        for(int i = N-1; i>=0; i--){
            if(arr[i] > t){
                ans++;
                t = arr[i];
            }
        }
        System.out.println(ans);
    }
}