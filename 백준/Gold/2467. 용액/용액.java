import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int [N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = N-1;
        if(arr[e] <= 0){
            System.out.println(arr[e-1] + " " + arr[e]);
        } else if (arr[s] >= 0) {
            System.out.println(arr[s] + " " + arr[s+1]);
        } else {
            int min = Integer.MAX_VALUE;
            int idx1 = 0;
            int idx2 = 0;
            while(s < e){
                int num = arr[s] + arr[e];
                if(min > Math.abs(num)){
                    min = Math.abs(num);
                    idx1 = s;
                    idx2 = e;
                }

                if(num == 0){
                    System.out.println(arr[s] + " " + arr[e]);
                    return;
                }else if(num < 0){
                    s++;
                }else{
                    e--;
                }
            }
            System.out.println(arr[idx1] + " " + arr[idx2]);
        }

    }
}