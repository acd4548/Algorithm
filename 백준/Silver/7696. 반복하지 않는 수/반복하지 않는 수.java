import java.util.*;
import java.io.*;

public class Main {
    static int [] ans = new int [1000001];
    static boolean checkNum [] = new boolean[10];
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int cnt = 1;
        int num = 1;
        while(true){
            //num 이 겹치는 수가 없는애라면
            //cnt를 1 더해주고 num도 1더해준다.
            if(check(num)) {
                ans[cnt++] = num;
            }
            if(cnt == 1000001) break;
            num++;
        }

        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == 0) return;
            System.out.println(ans[N]);
        }
    }
    // 겹치는 애가 있는지 없는지 확인하는 매서드
    public static boolean check(int n){
        Arrays.fill(checkNum, false);
        while(true){
            int num = n % 10;
            if(checkNum[num]) {
                return false;
            }
            checkNum[num] = true;
            n /= 10;
            if(n == 0) break;
        }
        return true;
    }
}