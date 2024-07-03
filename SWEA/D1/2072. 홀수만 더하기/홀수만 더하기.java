import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int num, sum;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            sb.append("#").append(tc).append(" ");
            sum = 0;
            for(int i = 0; i<10; i++){
                num = Integer.parseInt(st.nextToken());
                if(num % 2 == 1){
                    sum += num;
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}