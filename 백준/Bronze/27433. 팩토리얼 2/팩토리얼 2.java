import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger A = new BigInteger("1");
        BigInteger B;
        int num = Integer.parseInt(br.readLine());
        for(int i = num; i>0; i--){
            B = new BigInteger(String.valueOf(i));
            A = A.multiply(B);
        }
        System.out.println(A);
    }
}