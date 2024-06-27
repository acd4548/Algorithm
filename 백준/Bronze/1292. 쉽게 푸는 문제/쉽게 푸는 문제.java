import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int a, b;
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int ans = 0;

        int [] arr = new int [1010];
        int num = 1;
        int now = 0;
        for(int i = 1; i<1010; i++){
            if(now < num){
                arr[i] = num;
                now++;
            }else{
                num++;
                arr[i] = num;
                now = 1;
            }
        }
        for(int i = a; i<=b; i++){
            ans += arr[i];
        }
        System.out.print(ans);
    }
}