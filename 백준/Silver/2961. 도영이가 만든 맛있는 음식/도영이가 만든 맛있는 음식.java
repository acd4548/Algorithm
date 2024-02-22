import java.util.*;
import java.io.*;

public class Main {
    static int N, taste[][], min;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        taste = new int [N][2];
        min = Integer.MAX_VALUE;
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            taste[i][0] = Integer.parseInt(st.nextToken());
            taste[i][1] = Integer.parseInt(st.nextToken());
        }
        recur(0, 1, 0, 0);
        System.out.println(min);
    }

    static void recur(int cur, int S, int B, int cnt){
        if(cur == N){
            if(cnt > 0){
                min = Math.min(min, Math.abs(S - B));

            }
            return;
        }

        recur(cur+1, S, B, cnt);
        recur(cur+1, S*taste[cur][0], B+taste[cur][1], cnt+1);
    }
}