import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] arr = new int [N];
        int max = 2000000000;
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long s = 0;
        long e = max;
        long ans = Integer.MIN_VALUE;
        while(s <= e){
            long mid = (s + e) / 2;
            if(mid == 0) mid = 1;
            long cnt = 0;
            for(int i = 0; i<N; i++){
                cnt += arr[i] / mid;
            }

            if(cnt < K){
                e = mid - 1;
            }else if(cnt >= K){
                ans = Math.max(ans, mid);
                s = mid + 1;
            }
        }

        System.out.println(ans);

    }
}