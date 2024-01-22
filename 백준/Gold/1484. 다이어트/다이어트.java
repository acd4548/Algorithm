import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long G = Integer.parseInt(br.readLine());

        long s = 1;
        long e = G;

        int cnt = 0;
        while( s < e ){
            long sum = (e * e) - (s * s);

            if(sum > G){
                e--;
            }else if(sum == G){
                System.out.println(e);
                e = G;
                s++;
                cnt++;
            }else{
                e = G;
                s++;
            }
        }
        if(cnt == 0){
            System.out.println(-1);
        }
    }
}