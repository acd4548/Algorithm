import java.util.*;
import java.io.*;

public class Main{
    static int [] ans = new int [1000010];
    static int [] visited_arr = new int [10];
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 1;
        int num = 1;

        while(cnt <= 1000000){
            if(check(num)){
                ans[cnt] = num;
                cnt++;
            }

            num++;
        }

        StringBuilder sb = new StringBuilder();
        while(true){
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0){
                break;
            }
            sb.append(ans[temp]).append("\n");
        }
        System.out.println(sb);
    }


    private static boolean check(int num){
        Arrays.fill(visited_arr, 0);

        while(num > 0){
            visited_arr[num % 10]++;
            if(visited_arr[num % 10] >= 2){
                return false;
            }

            num /= 10;
        }
        return true;
    }
}