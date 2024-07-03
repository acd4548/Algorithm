import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        while(N > 0){
            ans += N % 10;
            N /= 10;
        }
        System.out.println(ans);
    }
}