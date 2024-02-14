import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());
        long [] arr = new long [N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        //입력 받아주기

        Arrays.sort(arr);

        int s = 0;      //시작idx
        int e = N-1;    //마지막 idx
        int cnt = N;    //전체병의개수
        int ans = 0;    //출력할 꽉채울수있는 병의 수
        while(true){    //꽉차있는애들 미리 제거해주기
            if(e < 0){
                System.out.println(ans);
                return;
            }
            if(arr[e] == X){
                ans++;
                cnt--;
                e--;
            }else{
                break;
            }
        }


        while(s < e){
            long sum = arr[s] + arr[e];
            if(2 * sum >= X){
                cnt -= 2;
                ans++;
                s++;
                e--;
            }else{
                s++;
            }
        }

        ans += cnt/3;

        System.out.println(ans);

    }
}