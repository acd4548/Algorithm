import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        long [] arr = new long [110];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
        for(int i = 6; i<110; i++){
            arr[i] = arr[i-1] + arr[i-5];
        }

        int num;
        for(int tc = 0; tc<T; tc++){
            num = Integer.parseInt(br.readLine());
            sb.append(arr[num]).append("\n");
        }
        System.out.println(sb);
    }
}