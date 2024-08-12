import java.util.*;
import java.io.*;

public class Main {
    static long a, b, min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        min = 12345678900L;
        recur(a, 1);
        if(min == 12345678900L){
            System.out.print(-1);
        }else{
            System.out.print(min);
        }
    }

    public static void recur(long cur, long cnt){
        if(cur == b){
            min = Math.min(min, cnt);
            return;
        }else if(cur > b){
            return;
        }


        recur(cur * 2, cnt + 1);
        recur(cur * 10 + 1, cnt + 1);
    }
}