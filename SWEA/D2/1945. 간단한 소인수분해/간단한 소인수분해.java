import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int num;
        int cnt = 0;
        int arr [] = {2, 3, 5, 7, 11};
        for(int tc = 1; tc<=N; tc++){
            sb.append("#").append(tc).append(" ");
            num = Integer.parseInt(br.readLine());

            for(int i = 0; i<5; i++){
                cnt = 0;
                while(true){
                    if(num % arr[i] == 0){
                        cnt++;
                        num /= arr[i];
                    }else{
                        break;
                    }
                }
                sb.append(cnt).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}