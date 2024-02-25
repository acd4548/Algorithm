import java.util.*;
import java.io.*;
public class Main {
    static int N, info[][], max;
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        info = new int [N][2];
        max = Integer.MIN_VALUE;
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }
        recur(0, 0);
        System.out.println(max);
    }

    static void recur(int cur, int income){
        if(cur == N){
            max = Math.max(income, max);
            return;
        }
        if(cur > N){
            return;
        }

        recur(cur+1, income);
        recur(cur+info[cur][0], income+info[cur][1]);
    }
}