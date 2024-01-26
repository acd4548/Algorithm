import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int A2 = A;
            int B2 = B;
            if(A > B){
                while(true){
                    if (A % B == 0) {
                        System.out.println(A);
                        break;
                    }else{
                        A += A2;
                    }
                }
            }else{
                while(true){
                    if(B % A == 0) {
                        System.out.println(B);
                        break;
                    }else{
                        B += B2;
                    }
                }
            }
        }
    }
}