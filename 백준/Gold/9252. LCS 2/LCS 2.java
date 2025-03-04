import java.io.*;
import java.util.*;

public class Main{

    static int [][] dp;
    static String str1, str2;
    static StringBuilder sb = new StringBuilder();
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = "a" + br.readLine();
        str2 = "b" + br.readLine();
        dp = new int [str1.length()][str2.length()];
        for(int i = 0; i<str1.length(); i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(dp(str1.length()-1, str2.length()-1));
        def(str1.length() - 1, str2.length() - 1);
        System.out.println(sb.reverse());
    }
    private static int dp(int x, int y){
        if(x < 0 || y < 0){
            return 0;
        }

        if(dp[x][y] != -1) return dp[x][y];

        if(str1.charAt(x) == str2.charAt(y)){
            dp[x][y] = dp(x - 1, y - 1) + 1;
        }else{
            dp[x][y] = Math.max(dp(x-1, y), dp(x, y-1));
        }
        return dp[x][y];
    }

    private static void def(int x, int y){
        if(x < 1 || y < 1){
            return;
        }
        if(str1.charAt(x) == str2.charAt(y)){
            sb.append(str1.charAt(x));
            def(x-1, y-1);
        }else{
            if(dp[x-1][y] > dp[x][y-1]){
                def(x-1, y);
            }else{
                def(x, y-1);
            }
        }
    }
}