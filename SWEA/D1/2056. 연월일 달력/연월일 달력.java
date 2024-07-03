import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int Y, M, D;
        String num, y, m, d;
        for(int tc = 1; tc<=T; tc++){
            sb.append("#").append(tc).append(" ");
            num = br.readLine();
            y = "";
            m = "";
            d = "";
            for(int i = 0; i<4; i++){
                y += String.valueOf(num.charAt(i));
            }
            Y = Integer.parseInt(y);

            for(int i = 4; i<6; i++){
                m += String.valueOf(num.charAt(i));
            }
            M = Integer.parseInt(m);

            if(M < 1 || M > 12){
                sb.append(-1).append("\n");
                continue;
            }

            for(int i = 6; i<8; i++){
                d += String.valueOf(num.charAt(i));
            }
            D = Integer.parseInt(d);

            if(D < 1){
                sb.append(-1).append("\n");
                continue;
            }else if(M == 2){
                if(D > 28){
                    sb.append(-1).append("\n");
                    continue;
                }
            }else if(M == 1 || M == 3 || M == 5 || M == 7 || M == 8 || M == 10 || M == 12 ){
                if(D > 31){
                    sb.append(-1).append("\n");
                    continue;
                }
            }else{
                if(D > 30){
                    sb.append(-1).append("\n");
                    continue;
                }
            }

            sb.append(y).append("/").append(m).append("/").append(d).append("\n");
        }
        System.out.print(sb);
    }
}