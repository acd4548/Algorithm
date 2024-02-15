import java.util.*;
import java.io.*;

public class Main {

    static int N, M, arr[], ans[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int [N+1];
        ans = new int [M+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        recur(1);
        System.out.println(sb);
    }

    private static void recur(int cur){
        if(cur > M){
            for(int i = 1; i<=M; i++){
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i<=N; i++){
                ans[cur] = arr[i];
                recur(cur+1);;
        }
    }
}