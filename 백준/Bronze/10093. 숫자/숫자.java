import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long temp = 0;
        if(a > b){
            temp = a;
            a = b;
            b = temp;
        }

        if(a == b || Math.abs(a - b) == 1){
            System.out.println(0);
            return;
        }


        sb.append(b - a - 1).append("\n");
        for(long i = a + 1; i<b; i++){
            sb.append(i).append(" ");
        }

        System.out.print(sb);
    }
}