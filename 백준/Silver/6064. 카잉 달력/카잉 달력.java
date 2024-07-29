import java.util.*;
import java.io.*;
public class Main {
    public static void main (String [] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        int M, N, x, y, cnt;
        for(int tc = 0; tc<T; tc++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            cnt = 1;
            int temp = 0;
            if(M > N){
                temp = M;
                M = N;
                N = temp;

                temp = x;
                x = y;
                y = temp;
            }
            //M이 무조건 더 작다.
            cnt = x;

            int a = x;
            int b = x;

            while(true){
                if(a == x && b == y){
                    sb.append(cnt).append("\n");
                    break;
                }

                b += M;
                cnt += M;

                if(b > N){
                    b -= N;
                }

                if(cnt > N * M){
                    sb.append(-1).append("\n");
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}