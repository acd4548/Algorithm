import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        if(P == 0 && N > 0){
            System.out.println(1);
            return;
        }
        st = new StringTokenizer(br.readLine());
        int [] arr = new int [P+1];
        for(int i = 1; i<P + 1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int rate = 1;
        int cnt = 0;
        for(int i = 1; i<P+1; i++){
            if(arr[i] > score){
                rate++;
            }else if(arr[i] < score){
                System.out.println(rate);
                return;
            }
            cnt++;
        }

        if(cnt == N){
            System.out.println(-1);
        }else{
            System.out.println(rate);
        }


    }
}