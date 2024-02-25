import java.util.*;
import java.io.*;
public class Main {
    static int info[][], used[], N, K, max;
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        info = new int [N+1][N+1];
        used = new int [K];
        max = Integer.MIN_VALUE;
        for(int i = 1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<N+1; j++){
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(1, 0);
        System.out.println(max);
    }

    static void recur(int cur, int idx){
        if(idx >= K){
            int taste = 0;
            for(int i = 0; i<K; i++){
                for(int j = i+1; j<K; j++){
                    taste += info[used[i]][used[j]];
                }
            }
            max = Math.max(taste, max);
            return;
        }
        if(cur > N) return;

        used[idx] = cur;
        recur(cur+1, idx+1);
        recur(cur+1, idx);
    }
}