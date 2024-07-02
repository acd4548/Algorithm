import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        String str1 = st.nextToken();
        str1 += st.nextToken();
        String str2 = st.nextToken();
        str2 += st.nextToken();

        BigInteger ans1 = new BigInteger(str1);
        BigInteger ans2 = new BigInteger(str2);
        BigInteger ans = ans1.add(ans2);
        System.out.println(ans);
    }
}