import java.util.*;
import java.io.*;
public class Main {
    static int ans = 0;
    public static void main (String [] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        recur(N, r, c);
        System.out.println(ans);
    }

    static void recur(int N, int r, int c){
        if(N == 1){
            if(r == 1 && c == 1){
                ans += 3;
            }else if(r == 1 && c == 0){
                ans += 2;
            }else if(r == 0 && c == 1){
                ans += 1;
            }

            return;
        }

        int len = 1;
        for(int i = 0; i<N; i++){
            len *= 2;
        }
        len /= 2;

        if(r >= len && c >= len){ //4 사분면일 때
            ans += (len * len) * 3;
            recur(N-1, r-len, c-len);
        }else if(r >= len){ // 3 사분면일 때
            ans += (len * len) * 2;
            recur(N-1, r-len, c);
        }else if(c >= len){ // 2 사분면일 때
            ans += (len * len);
            recur(N-1, r, c-len);
        }else{ // 1 사분면일 때
            recur(N-1, r, c);
        }
    }
}