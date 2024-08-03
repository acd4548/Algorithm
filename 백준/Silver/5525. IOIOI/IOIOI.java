import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        char [] arr = new char [M];
        int [] memo = new int [M];
        for(int i = 0; i<M; i++){
            arr[i] = S.charAt(i);
        }

        int cnt = 0;
        for(int i = 0; i<M-1; i++){
            if(arr[i] == 'O' && arr[i+1] == 'I'){
                if(i == 0){
                    memo[i+1] = 1;
                }else{
                    memo[i+1] = memo[i-1] + 1;
                }
            }

            if(memo[i+1] >= N && i >= N * 2 - 1 && arr[i + 1 - (N * 2)] == 'I'){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}