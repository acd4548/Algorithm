import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int num, sum, avg;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            sb.append("#").append(tc).append(" ");
            sum = 0;
            avg = 0;
            for(int i = 0; i<10; i++){
                num = Integer.parseInt(st.nextToken());
                sum += num;
            }
            
            if(sum % 10 >= 5){
                avg++;
            }
            
            avg += sum / 10;
            sb.append(avg).append("\n");
        }
        System.out.print(sb);
    }
}