import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int [] arr = new int [N];
        int max = -1;
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i]){
                max = arr[i];
            }
        }

        long cost = Long.MIN_VALUE;
        for(int i = 1; i<=max; i++){ // i가 잘린나무의 단위
            long count = 0; // 나무의 개수
            long cut = 0; // 자른 횟수
            for(int j = 0; j<N; j++){ // 해당 idx 나무관련
                int tree = arr[j] / i;
                int cutTemp = 0;
                if(arr[j] % i == 0){
                    cutTemp = arr[j] / i - 1;
                }else{
                    cutTemp = arr[j] / i;
                }

                if((tree * i * W) >= (cutTemp * C)){
                    count += tree;
                    cut += cutTemp;
                }
            }

            long temp = (count * i * W) - (C * cut);
            cost = Math.max(temp, cost);
        }

        System.out.println(cost);


    }
}