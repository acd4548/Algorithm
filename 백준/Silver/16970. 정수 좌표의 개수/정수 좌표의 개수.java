import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] arr = new int [60];

        for(int i = 0; i<=N; i++){
            for(int j = 0; j<=M; j++){
                for(int k = 0; k<=N; k++){
                    for(int q = 0; q<=M; q++){
                        int x = Math.abs(i - k);
                        int y = Math.abs(j - q);

                        if(x == y){
                            arr[x + 1]++;
                            continue;
                        }
                        arr[check(x, y) + 1]++;
                    }
                }
            }
        }
        System.out.println(arr[K] / 2);
    }

    private static int check(int x, int y){
        int a = 0;
        int b = 0;
        if(x >= y){
            a = x;
            b = y;
        }else{
            a = y;
            b = x;
        }

        if(a == 0){
            return b;
        }else if(b == 0){
            return a;
        }

        int temp = 0;
        while(true){
            if(a % b == 0){
                return b;
            }else{
                temp = b;
                b = a % b;
                a = temp;
            }
        }
    }
}