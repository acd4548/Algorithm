import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Integer [] arr = new Integer [10010];
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            int min = 101;
            for(int j = 0; j<7; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num % 2 == 0){
                    sum += num;
                    min = Math.min(num, min);
                }
            }
            sb.append(sum).append(" ").append(min).append("\n");
        }
        System.out.print(sb);
    }
}