import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int [] arr = new int [N];
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 1;

        if(N == 1){
            if(arr[0] % 2 == 0){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
            return;
        }

        int len = 0;    // 현재 길이
        int max = -1;   // 최대 길이
        int cnt = 0;    // 홀수 몇개 지웠는 지

        if(arr[0] % 2 != 0){
            cnt++;
        }else{
            len++;
            max = Integer.max(max, len);
        }
        while(s <= e && e < N){
            if(arr[e] % 2 == 0){    // 짝수라면
                len++;
                max = Integer.max(max, len);
                e++;
            }else{                  // 홀수라면
                if(cnt < K){ //아직 홀수제거횟수에 여유가 있을 때
                    e++;
                    cnt++;
                }else{
                    while(arr[s] % 2 == 0){
                        len--;
                        s++;
                    }
                    s++;
                    e++;
                }
            }
        }
        if(max == -1){
            System.out.println(0);
        }else{
            System.out.println(max);
        }
    }
}