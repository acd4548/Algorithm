import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long a = A;
        long b = B;

        long num = 0;
        long temp = 0;
        if(b > a){
            temp = a;
            a = b;
            b = temp;
        }

        while(true){
            if(a % b == 0){
                num = b;
                break;
            }else{
                temp = a % b;
                a = b;
                b = temp;
            }
        }

        System.out.println((A / num) * B);
    }
}