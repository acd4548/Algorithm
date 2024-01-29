import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int [] arr = new int [H+1];

        for(int i = 1; i<N+1; i++){
            int num = Integer.parseInt(br.readLine());
            if(i % 2 != 0){
                arr[1]++;
                arr[num+1]--;
            }else{
                arr[H-num+1]++;
            }
        }

        int [] prefix = new int [H+1];
        for(int i = 1; i<H+1; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for(int i = 1; i<H+1; i++){
            if(prefix[i] < min){
                min = prefix[i];
                cnt = 0;
            }

            if(prefix[i] == min){
                cnt++;
            }
        }


        System.out.println(min + " " + cnt);

    }
}