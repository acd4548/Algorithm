import java.util.*;
import java.io.*;
public class Main {
    static int n, m, k, max, info[][], sel[];
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;
        info = new int [m][k];
        sel = new int [n];
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<k; j++){
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(0, 0);
        System.out.println(max);
    }

    static void recur(int cur, int idx){
        if(idx >= n){
            int cnt = 0;
            for(int i = 0; i<m; i++){
                int num = 0;
                for(int j = 0; j<k; j++){
                    for(int q = 0; q<n; q++){
                        if(info[i][j] == sel[q]){
                            num++;
                            break;
                        }
                    }
                }
                if(num == k){
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
            return;
        }

        if(cur == 2 * n) return;

        sel[idx] = cur+1;
        recur(cur+1, idx+1);
        recur(cur+1, idx);
    }
}