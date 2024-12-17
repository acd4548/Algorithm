import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int [] arr = new int [N];
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int s = 0;
        int e = N - 1;
        int cnt = 0;
        int now = 0;
        int flag = 0;
        long answer = 0;
        while(cnt < K){
            if(flag == 0){
                answer += arr[e] - now;
                e--;
                flag = 1;
                cnt++;
            }else{
                now = arr[s];
                s++;
                flag = 0;
                cnt++;
            }
        }
        System.out.println(answer);
    }
}