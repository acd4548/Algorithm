import java.util.*;
import java.io.*;
public class Solution {
    static boolean flag = false;
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int P, Q, R, S, W, feeA, feeB;

        for(int tc = 1; tc<=T; tc++){
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            feeA = 0;
            feeB = 0;

            feeA = P * W;
            feeB = Q;
            if(W > R){
                feeB += (W - R) * S;
            }

            if(feeA <= feeB){
                sb.append(feeA).append("\n");
            }else{
                sb.append(feeB).append("\n");
            }
        }
        System.out.print(sb);
    }
}