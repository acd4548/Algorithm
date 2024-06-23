import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] arr = new int [7];
        StringTokenizer st;
        for(int i = 0; i<7; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i<7; i++){
            if(arr[i] % 2 == 1){
                sum += arr[i];
                min = Math.min(min, arr[i]);
            }
        }

        if(sum != 0){
            System.out.println(sum);
            System.out.println(min);    
        }else{
            System.out.println(-1);
        }
        
    }
}