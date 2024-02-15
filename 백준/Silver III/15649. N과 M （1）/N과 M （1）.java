import java.util.*;
import java.io.*;

public class Main {

    static int N, M, visited[], arr[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int [N+1];
        arr = new int [M+1];
        recur(1);
        System.out.println(sb);
    }

    public static void recur(int cur){
        if(cur > M){
            for(int i = 1; i<=M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i<=N; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                arr[cur] = i;
                recur(cur+1);
                visited[i] = 0;
            }
        }

    }
}