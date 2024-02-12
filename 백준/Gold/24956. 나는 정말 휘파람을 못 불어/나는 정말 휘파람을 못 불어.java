import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력 받기
        int N = Integer.parseInt(br.readLine());    // 문자열의 길이
        String str = br.readLine();                 // 문자열

        long cnt = 0;
        int prefixW [] = new int [N+1];
        int prefixH [] = new int [N+1];
        int prefixE [] = new int [N+1];

        for(int i = 1; i<N+1; i++){
            if(str.charAt(i-1) == 'W'){
                prefixW[i] = prefixW[i-1] + 1;
                prefixH[i] = prefixH[i-1];
                prefixE[i] = prefixE[i-1];
            }else if(str.charAt(i-1) == 'H'){
                prefixW[i] = prefixW[i-1];
                prefixH[i] = prefixH[i-1] + 1;
                prefixE[i] = prefixE[i-1];
            }else if(str.charAt(i-1) == 'E'){
                prefixW[i] = prefixW[i-1];
                prefixH[i] = prefixH[i-1];
                prefixE[i] = prefixE[i-1] + 1;
            }else{
                prefixW[i] = prefixW[i-1];
                prefixH[i] = prefixH[i-1];
                prefixE[i] = prefixE[i-1];
            }
        }


        for(int i = 0; i<N; i++){
            if(str.charAt(i) == 'H'){
                int num = prefixE[N] - prefixE[i+1];
                cnt += prefixW[i+1] * (getMul(num) - num - 1);
                cnt %= 1000000007;
            }
        }
        System.out.println(cnt);
    }

    private static long getMul(long x) {
        if (x == 0) return 1;
        long result = getMul(x/2);
        if (x%2 == 0) {
            return (result * result) % 1000000007;
        } else {
            return (result * result * 2) % 1000000007;
        }
    }
}