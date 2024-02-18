import java.util.*;
import java.io.*;
public class Main {

    static int N, S, arr[], cnt;
    static long num;


    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int [N];
        num = 0;
        cnt = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        recur(0);
        System.out.println(cnt);
    }

    private static void recur(int cur){
        if(cur >= N){
            return;
        }

        num += arr[cur];
        if(num == S){
            cnt++;
        }
        recur(cur+1);
        num -= arr[cur];
        recur(cur+1);

    }
}