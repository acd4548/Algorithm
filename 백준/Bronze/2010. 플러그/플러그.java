import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int ans = 0;
        for(int i = 0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            cnt++;
            ans += num;
        }

        ans = ans - cnt + 1;
        System.out.println(ans);
    }
}