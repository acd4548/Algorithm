import java.util.*;
import java.io.*;
public class Solution {
    static boolean flag = false;
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int num, ans;
        for(int tc = 1; tc<=T; tc++){
            sb.append("#").append(tc).append(" ");
            num = Integer.parseInt(br.readLine());
            ans = 0;
            for(int i = 1; i<=num; i++){
                if(i % 2 == 1){
                    ans += i;
                }else{
                    ans -= i;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}