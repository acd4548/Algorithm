import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int num, max;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            max = Integer.MIN_VALUE;
            sb.append("#").append(tc).append(" ");
            for(int i = 0; i<10; i++){
                num = Integer.parseInt(st.nextToken());
                max = Math.max(num, max);
            }
            sb.append(max).append("\n");
        }
        System.out.print(sb);
    }
}