import java.util.*;
import java.io.*;

public class Main {

    static int len, arr[], visited[], ans[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            len = Integer.parseInt(st.nextToken());
            if(len == 0){
                break;
            }

            arr = new int [len+1];
            visited = new int [len+1];
            ans = new int [7];

            for(int i = 1; i<len+1; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            recur(1);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void recur(int cur){
        if(cur > 6){
            for(int i = 1; i<7; i++){
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i<len+1; i++){
            if (visited[i] == 0) {
                ans[cur] = arr[i];
                if(ans[cur] <= ans[cur-1]){
                    continue;
                }
                visited[i] = 1;
                recur(cur+1);
                visited[i] = 0;
            }
        }
    }
}