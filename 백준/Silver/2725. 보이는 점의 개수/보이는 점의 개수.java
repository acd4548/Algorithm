import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] dp = new int [1010];
        dp[1] = 3;
        for(int i = 2; i<=1000; i++){
            int cnt = 0;
            for(int j = 1; j<=i; j++){
                if(check(j, i)) cnt++;
            }
            dp[i] = dp[i-1] + (cnt * 2) + 2;
        }

        StringBuilder sb = new StringBuilder();
        int C = Integer.parseInt(br.readLine());
        for(int tc = 0; tc<C; tc++){
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }
        System.out.print(sb);
    }
    private static boolean check(int a, int b){
        int temp = 0;
        while(true){
            if(b % a == 1){
                return true;
            }else if(b % a == 0){
                return false;
            }else{
                temp = b % a;
                b = a;
                a = temp;
            }
        }
    }
}