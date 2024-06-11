import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        BigInteger N = sc.nextBigInteger();
        BigInteger M = sc.nextBigInteger();

        StringBuilder sb = new StringBuilder();
        sb.append(N.divide(M)).append("\n");
        sb.append(N.mod(M));
        System.out.println(sb);
    }
}