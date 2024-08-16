import java.util.*;
import java.io.*;
public class Main {
    static int N, M, arr[], visited[], picked[];
    static StringBuilder sb = new StringBuilder();
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int [N];
        visited = new int [N];
        picked = new int [M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        recur(0);
        System.out.print(sb);
    }

    private static void recur(int cur){
        if(cur >= M){
            for(int i = 0; i<M; i++){
                sb.append(picked[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for(int i = 0; i<N; i++){
            if(visited[i] == 1) continue;

            if(arr[i] != before){
                before = arr[i];
                picked[cur] = arr[i];
                visited[i] = 1;
                recur(cur + 1);
                visited[i] = 0;
            }
        }
    }
}