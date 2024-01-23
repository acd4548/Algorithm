import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int [] arr = new int [N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int p1 = 0;
        int p2 = 0;

        int sum = arr[p1];
        int cnt = Integer.MAX_VALUE;
        while(p2 < N){
            if(p1 == p2){
                if(sum >= S){
                    cnt = 1;
                    break;
                }else{
                    p2++;
                    if(p2 == N) break;
                    sum += arr[p2];
                }
            }

            if(sum >= S){
                cnt = Math.min((p2 - p1 + 1), cnt);
                sum -= arr[p1];
                p1++;
            }else{
                p2++;
                if(p2 ==N) break;
                sum += arr[p2];
            }
        }

        if(cnt == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(cnt);
        }
    }
}