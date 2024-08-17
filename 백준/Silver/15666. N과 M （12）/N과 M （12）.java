import java.util.*;
import java.io.*;

public class Main {
    static int N, M, picked[], arr[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int [N];
        picked = new int [M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        recur(0, 0);
        System.out.println(sb);
    }

    static void recur(int cur, int idx){
        if(idx == M){
            for(int i = 0; i<M; i++){
                sb.append(picked[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for(int i = cur; i<N; i++){
            if(before == arr[i]) continue;
            picked[idx] = arr[i];
            before = arr[i];
            recur(i, idx + 1);
        }
    }
}