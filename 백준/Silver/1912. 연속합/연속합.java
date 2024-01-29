import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int [N+1];
        int [] prefix = new int [N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i-1] + arr[i];
        }

        int max = Integer.MIN_VALUE;
        int minPrefix = 0;

        for(int i = 1; i<N+1; i++){
            max = Math.max(max, prefix[i] - minPrefix);
            minPrefix = Math.min(minPrefix, prefix[i]);
        }

        System.out.println(max);
    }
}