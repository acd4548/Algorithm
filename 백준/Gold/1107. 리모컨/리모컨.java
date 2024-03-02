import java.util.*;
import java.io.*;
public class Main {

    static int N, M, ban[], sel[], len, cnt, flag;
    static String str;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();    // 도달해야하는 숫자
        len = str.length();     // 그 숫자의 길이
        sel = new int [len+1];    // 각 자리수마다 선택된(버튼을 누른) 그 숫자
        N = Integer.parseInt(str);
        M = Integer.parseInt(br.readLine());
        cnt = Math.abs(N - 100);    //100부터 해당 번호까지 그냥 +또는 -를통해 간다면..
        flag = 0; // 큰 자리수부터 0이아닌 수가 입력되었는지 확인한는 flag
        if(M > 0){ // 고장난 버튼의 개수가 0보다 클 때.
            ban = new int [M];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i<M; i++){
                ban[i] = Integer.parseInt(st.nextToken());
            }
        }
        recur(0, 0);
        System.out.println(cnt);
    }

    static void recur(int cur, int click){
        if (click >= 1 && cur <= len+1 && cur > 0){
            int num = 0;
            for(int i = 0; i<cur; i++){
                num += sel[i];
                if(i < cur-1){
                    num *= 10;
                }
            }
            if(cnt > Math.abs(num - N) + click){
                cnt = Math.abs(num - N) + click;
            }
        }

        if(cur >= len+1) return;

        for(int i = 0; i<10; i++){
            int check = 0;
            for(int j = 0; j<M; j++){
                if( i == ban[j]) {
                    check = 1;
                    break;
                }
            }
            if(check == 1) continue;
            sel[cur] = i;
            if(flag == 0 && cur == len-1 && i == 0){
                recur(cur+1, click+1);
            }else if(flag == 0){
                if(i == 0){
                    recur(cur+1, click);
                }else{
                    flag = 1;
                    recur(cur+1, click+1);
                    flag = 0;
                }
            }else{
                recur(cur+1, click+1);
            }
        }
    }
}