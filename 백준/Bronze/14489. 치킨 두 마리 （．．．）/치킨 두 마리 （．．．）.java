import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int sum = a + b;
        int price = Integer.parseInt(br.readLine());

        if(sum >= (price * 2)){
            System.out.println(sum - (price * 2));
        }else{
            System.out.println(sum);
        }
    }
}