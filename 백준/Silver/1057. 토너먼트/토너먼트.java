import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int lim = Integer.parseInt(st.nextToken());

        if(kim > lim){
            System.out.println(check(lim, kim));
        }else{
            System.out.println(check(kim, lim));
        }
    }

    private static int check(int n, int m){
        int cnt = 1;
        while(true){
            if(m % 2 == 0 && n + 1 == m){
                return cnt;
            }else{
                if(n % 2 == 0){
                    n /= 2;
                }else{
                    n = (n + 1) / 2;
                }

                if(m % 2 == 0){
                    m /= 2;
                }else{
                    m = (m + 1) / 2;
                }
                cnt++;
            }
        }
    }
}