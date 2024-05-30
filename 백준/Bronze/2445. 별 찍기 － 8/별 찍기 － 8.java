import java.util.*;
import java.io.*;

public class Main {

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int temp = N-1;
        StringBuilder sb = new StringBuilder();
        while(temp >= 0){
            for(int i = N; i>temp; i--){
                sb.append("*");
            }

            for(int i = 0; i<temp; i++){
                sb.append("  ");
            }

            for(int i = N; i>temp; i--){
                sb.append("*");
            }

            sb.append("\n");
            temp--;
        }

        temp = N-1;

        while(temp > 0){
            for(int i = 0; i<temp; i++){
                sb.append("*");
            }

            for(int i = N; i>temp; i--){
                sb.append("  ");
            }

            for(int i = 0; i<temp; i++){
                sb.append("*");
            }

            sb.append("\n");
            temp--;
        }

        System.out.println(sb);
    }
}