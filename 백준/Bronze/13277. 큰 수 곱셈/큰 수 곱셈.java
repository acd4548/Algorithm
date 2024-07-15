import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger n1 = new BigInteger(st.nextToken());
        BigInteger n2 = new BigInteger(st.nextToken());

        n1 = n1.multiply(n2);
        System.out.print(n1);
    }
}