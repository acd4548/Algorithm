import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        System.out.println(function(b) - function(a-1));
    }

    private static long function(long num){
        long ans = 0;
        if(num % 2 == 0){
            ans += num / 2;
        }else{
            ans += num / 2 + 1;
        }

        ans += (num / 2) * 2;
        long t = 4;
        while(true){
            long cnt = num / t;
            if(cnt > 0){
                ans -= cnt * (t / 2);
                ans += cnt * t;
                t *= 2;
            }else{
                break;
            }
        }
        return ans;
    }
}