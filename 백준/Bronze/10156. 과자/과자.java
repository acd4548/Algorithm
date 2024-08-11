import java.util.*;
import java.io.*;
public class Main {
    public static void main (String [] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int ans = (K * N) - M;
        if(ans > 0){
            System.out.print(ans);
        }else{
            System.out.print(0);
        }
    }
}