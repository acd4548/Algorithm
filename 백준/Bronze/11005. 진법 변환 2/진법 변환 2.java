import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        String [] arr = new String [36];
        for(int i = 0; i<36; i++){
            if(i < 10){
                arr[i] = String.valueOf(i);
            }else{
                arr[i] = Character.toString(Character.forDigit(i, 36)).toUpperCase();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(N > 0){
            int idx = (int)N % B;
            sb.insert(0, arr[idx]);
            N -= idx;
            N /= B;
        }
        System.out.print(sb);
    }
}