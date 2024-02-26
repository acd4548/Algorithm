import java.util.*;
import java.io.*;
public class Main {
    static int ans[], sel[], num;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ans = new int [10];
        sel = new int [10];
        num = 0;
        for(int i = 0; i<10; i++){
            ans[i] = Integer.parseInt(st.nextToken());
        }

        recur(0);
        System.out.println(num);
    }

    static void recur(int cur){
        if(cur >= 10){

            for(int i = 2; i<10; i++){
                if(sel[i] == sel[i-1] && sel[i] == sel[i-2]) return;
            }

            int cnt = 0;
            for(int i = 0; i<10; i++){
                if(sel[i] == ans[i])cnt++;
                if(cnt == 5){
                    num++;
                    return;
                }
            }
            return;
        }

        sel[cur] = 1;
        recur(cur+1);
        sel[cur] = 2;
        recur(cur+1);
        sel[cur] = 3;
        recur(cur+1);
        sel[cur] = 4;
        recur(cur+1);
        sel[cur] = 5;
        recur(cur+1);
    }


}