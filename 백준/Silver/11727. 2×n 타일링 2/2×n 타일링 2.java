import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int [] arr = new int [N+1];
        for(int i = 1; i<N+1; i++){
            sum += arr[i-1];
            if(i % 2 == 0){
                arr[i] = (sum + 2) % 10007;
            }else{
                arr[i] = (sum + 1) % 10007;
            }
        }
        System.out.println(arr[N]);
    }
}