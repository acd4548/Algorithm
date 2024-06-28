import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int a, b;
        int num = 0;
        int max = 0;
        for(int i = 0; i<4; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            num -= a;
            num += b;
            max = Math.max(max, num);
        }

        System.out.println(max);
    }
}