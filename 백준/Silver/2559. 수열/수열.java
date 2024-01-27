import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 총 날짜의 개수
        int K = Integer.parseInt(st.nextToken()); // 몇 일 동안의 합을 볼지

        int [] arr = new int [N+1];
        int [] prefix = new int [N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i-1] + arr[i];
        }

        int max = Integer.MIN_VALUE;
        for(int i = K; i<N+1; i++){
            int num = prefix[i] - prefix[i-K];
            max = Math.max(max, num);
        }

        System.out.println(max);

    }
}