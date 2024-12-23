import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            BigInteger ans = new BigInteger("1");

            for(int i = 0; i<N; i++){
                BigInteger temp = new BigInteger(String.valueOf(M-i));
                ans = ans.multiply(temp);
            }

            for(int i = 0; i<N; i++){
                BigInteger temp = new BigInteger(String.valueOf(N-i));
                ans = ans.divide(temp);
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}