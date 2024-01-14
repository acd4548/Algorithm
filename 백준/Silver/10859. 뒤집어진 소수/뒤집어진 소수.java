import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        if( N == 1 ){
            System.out.println("no");
            return;
        }

        long temp = N;
        long num = 0;
        //입력받은 N을 뒤집어주는 코드
        while (N > 0) {
            long left = N % 10;

            if (left == 3 || left == 4 || left == 7) {
                System.out.println("no");
                return;
            } else if (left == 6) {
                num *= 10;
                num += 9;
            } else if (left == 9) {
                num *= 10;
                num += 6;
            } else {
                num *= 10;
                num += left;
            }
            N /= 10;
        }

        boolean a = check(temp);
        boolean b = check(num);

        if( a && b ){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }

    //들어온 이 숫자가 소수인지 파악하는 숫자.
    public static boolean check(long N){
        double sqrt = Math.sqrt(N);
        for(int i = 2; i<=sqrt; i++){
            if(N % i == 0){
                return false; //얘 소수 아니에요 !
            }
        }
        return true;
    }
}