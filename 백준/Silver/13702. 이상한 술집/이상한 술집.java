import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long [] arr = new long [N];
        long max = -1;
        for(int i = 0; i<N; i++){
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(arr[i], max);
        }

        long s = 1;
        long e = max;
        long cnt = 0;

        if(max == 0){
            System.out.println(0);
            return;
        }
        while(s <= e){
            cnt = 0;
            long mid = (s + e) / 2;
            for(int i = 0; i<N; i++){
                cnt += arr[i] / mid;
                if(cnt > K) break;
            }

            if(cnt >= K){
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        System.out.println(e);
       
    }
}