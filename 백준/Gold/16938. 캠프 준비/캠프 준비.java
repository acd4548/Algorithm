import java.util.*;
import java.io.*;

public class Main {

    static int N, L, R, X, arr[], cnt;
    static long max, min, sum, ans;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());    //입력받기
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int [N];
        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;
        sum = 0;
        ans = 0;
        cnt = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        recur(0);
        System.out.println(ans);

    }

    private static void recur(int cur) {
        if(cur >= N){
            if(sum >= L && sum <= R && max - min >= X && cnt >= 2){ // 모든 조건을 만족할 때 ans++;
                ans++;
            }
            return;
        }

        sum += arr[cur];                //일단 arr[cur]을 더해줬을 경우 ( 이번 cur을 사용할때 )
        cnt++;
        long tempMax = max;
        long tempMin = min;
        max = Math.max(arr[cur], max);
        min = Math.min(arr[cur], min);  //처리 다해줬다면 다음 cur로!
        recur(cur+1);
        sum -= arr[cur];                //다녀왔으면 원상복구하고 다시 다음cur로! ( 이번 cur을 사용하지 않을 때 )
        cnt--;
        max = tempMax;
        min = tempMin;
        recur(cur+1);
    }
}