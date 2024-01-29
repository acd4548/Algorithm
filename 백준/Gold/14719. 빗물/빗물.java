import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int sum = 0;
        int [] arr = new int [W+1];
        int [] prefix = new int [W+1];
        int [] surfix = new int [W+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<W+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            prefix[i] = Math.max(arr[i], prefix[i-1]);
            sum += arr[i];
        }

        surfix[W] = arr[W];
        for(int i = W-1; i>0; i--){
            surfix[i] = Math.max(surfix[i+1], arr[i]);
        }

        int ans = 0;
        for(int i = 1; i<W+1; i++){
            ans += Math.min(prefix[i], surfix[i]);
        }
        ans -= sum;
        System.out.println(ans);
    }
}