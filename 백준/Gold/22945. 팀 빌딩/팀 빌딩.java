import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int [N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = N-1;
        long ans = Long.MIN_VALUE;
        while(s < e){
            int state = (e - s - 1) * Math.min(arr[s], arr[e]);

            if(state > ans){
                ans = state;
            }

            if(arr[s] <= arr[e]){
                s++;
            }else if(arr[e] < arr[s]){
                e--;
            }

        }
        System.out.println(ans);
    }
}