import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [] arr = new long [N];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long ans = 0;
        for(int i = 0; i<N; i++){
            if(arr[i] <= B){
                ans++;
            }else{
                arr[i] -= B;
                ans++;
                ans += arr[i] / C;
                if(arr[i] % C > 0){
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}