import java.util.*;
import java.io.*;

public class Main {

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int rem = N;
        while(N > 0){
            for(int i = 0; i<rem - N; i++){
                sb.append(" ");
            }

            for(int i = N; i>1; i--){
                sb.append("*");
            }

            sb.append("*");

            for(int i = N; i>1; i--){
                sb.append("*");
            }

            sb.append("\n");
            N--;
        }

        System.out.println(sb);
    }
}