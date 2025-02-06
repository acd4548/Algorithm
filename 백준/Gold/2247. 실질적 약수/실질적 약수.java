import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i = 2; i<=N; i++){
            ans += ((N / i) - 1) * i;
            ans %= 1000000;
        }
        System.out.println(ans % 1000000);
    }
}