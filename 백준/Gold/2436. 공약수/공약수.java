import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        if(a == b){
            System.out.println(a + " " + a);
            return;
        }

        long c = a * b;

        long ans = Long.MAX_VALUE;
        long num1 = 0;
        long num2 = 0;

        for(long i = 2; i * i<c; i++){
            if(c % i == 0 && gcd(c / i, i) == a){
                if(ans > i + (c / i)){
                    ans = i + (c / i);
                    num1 = i;
                    num2 = c / i;
                }
            }
        }
        System.out.println(num1 + " " + num2);
    }

    private static long gcd(long num1, long num2){
        while(num2 != 0){
            long temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }
        return num1;
    }
}