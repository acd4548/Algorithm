import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger N = new BigInteger(st.nextToken());
        BigInteger M = new BigInteger(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append(N.divide(M)).append("\n");
        sb.append(N.mod(M));
        System.out.println(sb);
    }
}