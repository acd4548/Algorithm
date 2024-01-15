import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        boolean check [] = new boolean [B+1];
        check[1] = true;
        for(int i = 2; i * i <= B; i++){
            if(!check[i]){
                for(int j = i * i; j <= B; j += i){
                    check[j] = true;
                }
            }
        }

        int ans = 0;
        for(int i = A; i<=B; i++){
            if(!check[i]){
                int k = i;
                while(k > 0){
                    if(k % 10 == D){
                        ans++;
                        break;
                    }else{
                        k /= 10;
                    }
                }
            }
        }

        System.out.println(ans);

    }
}