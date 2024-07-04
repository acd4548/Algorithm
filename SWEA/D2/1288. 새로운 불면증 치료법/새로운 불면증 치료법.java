import java.util.*;
import java.io.*;
public class Solution {
    static boolean flag = false;
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        long num, temp, arr[];
        int t, cnt;
        String str;

        for(int tc = 1; tc<=T; tc++){
            sb.append("#").append(tc).append(" ");
            num = Long.parseLong(br.readLine());
            temp = num;
            arr = new long [11];

            while(true){
                str = String.valueOf(num);
                cnt = 0;

                for(int i = 0; i<str.length(); i++){
                    t = str.charAt(i) - '0';
                    if(arr[t] == 0) {
                        arr[t] = 1;
                    }
                }

                for(int i = 0; i<11; i++){
                    if(arr[i] == 1) cnt++;
                }

                if(cnt == 10){
                    sb.append(num).append("\n");
                    break;
                }else{
                    num += temp;
                }
            }
        }
        System.out.print(sb);
    }
}