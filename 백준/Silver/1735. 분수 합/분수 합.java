import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int f_num1 = Integer.parseInt(st.nextToken());
        int s_num1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int f_num2 = Integer.parseInt(st.nextToken());
        int s_num2 = Integer.parseInt(st.nextToken());

        int num1 = (f_num1 * s_num2) + (f_num2 * s_num1);
        int num2 = s_num1 * s_num2;

        int A = num2;
        int B = num1;
        int num = 0;
        int temp = 0;
        while(true){
            if(A % B == 0){
                num = B;
                break;
            }else{
                temp = A % B;
                A = B;
                B = temp;
            }
        }

        num1 /= num;
        num2 /= num;
        System.out.println(num1 + " " + num2);
    }
}