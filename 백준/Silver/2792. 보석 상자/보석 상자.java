import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken()); // 학생수
        int M = Integer.parseInt(st.nextToken()); // 색상수

        long [] arr = new long [M];
        long max = 1;
        for(int i = 0; i<M; i++){
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(arr[i], max);
        }

        long cnt = 0;
        long ans = 0;
        long s = 1;
        long e = max;
        while(s <= e){
            cnt = 0;
            long mid = (s + e) / 2;

            for(int i = 0; i<M; i++) {
                cnt += arr[i] / mid;
                if (arr[i] % mid != 0) {
                    cnt++;
                }
            }

            if(cnt > N) {
                s = mid + 1;
            }else{
                ans = mid;
                e = mid - 1;
            }
        }
        System.out.println(ans);
    }
}