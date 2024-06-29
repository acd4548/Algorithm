import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int a, b, c, d, num;
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());

        c += d % 60;
        d /= 60;
        if(c >= 60){
            d += (c / 60);
            c %= 60;
        }

        b += d % 60;
        d /= 60;
        if(b >= 60){
            d += (b / 60);
            b %= 60;
        }

        a += d;
        if(a >= 24){
            a %= 24;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(a).append(" ").append(b).append(" ").append(c);
        System.out.print(sb);
    }
}