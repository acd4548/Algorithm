import java.util.*;
import java.io.*;

public class Main {

    static int N, arr[], visited[], max, ans[];

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int [N];
        visited = new int [N];
        ans = new int [N];
        max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        recur(0);

        System.out.println(max);
    }

    private static void recur(int cur){
        if(cur >= N){
            int num = 0;
            for(int i = 0; i<N-1; i++){
                num += Math.abs(ans[i] - ans[i+1]);
            }
            if(max < num){
                max = num;
            }
            return;
        }

        for(int i = 0; i<N; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                ans[cur] = arr[i];
                recur(cur+1);
                visited[i] = 0;
            }
        }
    }
}