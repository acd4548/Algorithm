import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = -1;
        int num = 0;
        StringTokenizer st;
        for(int i = 0; i<10; i++){
            st = new StringTokenizer(br.readLine());
            int output = Integer.parseInt(st.nextToken());
            int input = Integer.parseInt(st.nextToken());

            num = num - output + input;
            max = Math.max(num, max);
        }
        System.out.println(max);
    }
}