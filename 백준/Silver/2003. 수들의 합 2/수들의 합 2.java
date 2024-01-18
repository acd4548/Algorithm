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
        
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;

        int ans = 0;

        int sum = 0;

        while(e < N && s < N){
            sum = 0;

            for(int i = s; i<=e; i++){
                sum += arr[i];
            }

            if(sum > M && s == e){
                s++;
                e++;
            }else if(sum > M){
                s++;
            }else if(sum < M){
                e++;
            }else if(sum == M){
                ans++;
                e++;
                s++;
            }
        }

        System.out.println(ans);

    }
}