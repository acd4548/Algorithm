import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] arr = new int [N];


        st = new StringTokenizer(br.readLine());
        long max = Integer.MIN_VALUE;
        long min = 0;
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(max < arr[i]){
                max = arr[i];
            }
        }

        long sum = 0;
        long ans = 0;
        while(true){
            long checkTop = (max + min) / 2;
            if(min > checkTop || max < checkTop) break;

            sum = 0;
            for(int i = 0; i<N; i++){
                if(arr[i] > checkTop){
                    sum += arr[i] - checkTop;
                }
            }

            if(sum == M){
                ans = checkTop;
                break;
            }else if(sum > M){
                ans = checkTop;
                min = checkTop + 1;
            }else if(sum < M){
                max = checkTop - 1;
            }

        }
        System.out.println(ans);
    }
}