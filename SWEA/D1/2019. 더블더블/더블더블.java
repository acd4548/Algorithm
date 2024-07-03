import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append(1).append(" ");
        int num = Integer.parseInt(br.readLine());
        int ans = 1;
        for(int i = 0; i<num; i++){
            ans *= 2;
            sb.append(ans).append(" ");
        }
        System.out.println(sb);
    }
}