import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        boolean [] arr = new boolean [2000001]; // false가 소수

        for(int i = 2; i<=1414; i++){
            if(!arr[i]){
                for(int j = i * i; j<2000001; j+=i){
                    arr[j] = true;
                }
            }
        }

        for(int t = 0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            //둘이 합쳐서 2 또는 3인 경우를 처리해주는 코드
            if(a == 1 && b == 1){
                System.out.println("NO");
                continue;
            }else if((a == 1 && b == 2) || (a == 2 && b == 1)){
                System.out.println("NO");
                continue;
            }
            //끝

            // 짝수 + 짝수 = 짝수 인 경우와 홀수 + 홀수 = 짝수 인경우를 미리 처리
            if(((a % 2 == 0) && (b % 2 == 0)) || ((a % 2 == 1) && (b % 2 == 1))){
                System.out.println("YES");
            }else{
                //남은건 한쪽만 홀수인 경우.
                long Q = a + b - 2; // Q만 소수인지 판단하면 끝.
                boolean check = true;
                double num = Math.sqrt(Q);
                for(int i = 2; i<= num; i++){
                    if(!arr[i] && (Q%i == 0)){
                        check = false;
                        break;
                    }
                }
                if(check){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }
}