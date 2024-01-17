import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean arr[] = new boolean[100000001];
        arr[1] = true;
        for(int i = 2; i<=10000; i++){
            if(!arr[i]){
                for(int j = i * i; j<100000001; j+=i){
                    arr[j] = true;
                }
            }
        }

        for(int i = a; i<=b; i++){
            if(arr[i]) continue;

            boolean check = true;

            String temp = String.valueOf(i);
            int len = temp.length();
            if(len % 2 == 1){
                len++;
            }
            int temp1 = i;
            for(int j = 0; j<len-1; j++){
                if((temp.charAt(j) - '0') != (temp1%10)){
                    check = false;
                    break;
                }
                temp1 /= 10;
            }
            if(check){
                System.out.println(i);
            }
        }
        System.out.println(-1);
    }
}