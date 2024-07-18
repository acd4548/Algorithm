import java.util.*;
import java.io.*;
public class Main {
    static int min;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        min = 5;

        check(N, 0);

        System.out.println(min);
    }
    private static void check(int cur, int cnt){
        if(cur == 0){
            min = Math.min(min, cnt);
        }

        if(cnt > 4 || cnt >= min) return;

        int num = (int)Math.sqrt(cur);

        int dif, div;
        for(int i = num; i>0; i--){
            dif = i * i;
            div = cur / dif;
            check(cur - (dif * div), cnt + div);
        }
    }
}