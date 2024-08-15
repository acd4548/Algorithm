import java.util.*;
import java.io.*;
public class Main {
    public static void main (String [] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        char [] arr1 = new char [str1.length() + 1];
        char [] arr2 = new char [str2.length() + 1];

        for(int i = 0; i<str1.length(); i++){
            arr1[i + 1] = str1.charAt(i);
        }

        for(int i = 0; i<str2.length(); i++){
            arr2[i + 1] = str2.charAt(i);
        }

        int [][] dp = new int [str1.length() + 1][str2.length() + 1];

        for(int i = 1; i<str1.length() + 1; i++){
            for(int j = 1; j<str2.length() + 1; j++){
                if(arr1[i] == arr2[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        System.out.println(dp[str1.length()][str2.length()]);
    }
}