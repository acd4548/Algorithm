import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long a = 0;
        long b = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<4; i++){
            a += Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<4; i++){
            b += Integer.parseInt(st.nextToken());
        }

        if(a > b){
            System.out.print(a);
        }else{
            System.out.print(b);
        }
    }
}