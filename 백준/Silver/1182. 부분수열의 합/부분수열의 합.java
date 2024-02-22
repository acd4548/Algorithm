import java.util.*;
import java.io.*;

public class Main {
    static int N, S, arr[], cnt;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int [N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        cnt = 0;
        recur(0, 0, 0);
        System.out.println(cnt);
    }

    static void recur(int cur, int sum, int sel){
        if(cur == N){
            if(sum == S && sel > 0){
                cnt++;
            }
            return;
        }

        recur(cur+1, sum, sel);
        recur(cur+1, sum+arr[cur], sel+1);
    }
}