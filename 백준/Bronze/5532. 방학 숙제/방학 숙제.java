import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());

        int ans1 = 0;
        int ans2 = 0;

        if(A % C == 0){
            ans1 = A / C;
        }else{
            ans1 = A / C + 1;
        }

        if(B % D == 0){
            ans2 = B / D;
        }else{
            ans2 = B / D + 1;
        }

        int ans = Math.max(ans1, ans2);

        System.out.println(L - ans);
    }
}