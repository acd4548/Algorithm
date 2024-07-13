import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int num = 0;
        for(int i = 0; i<9; i++){
            num = Integer.parseInt(br.readLine());
            T -= num;
        }
        System.out.println(T);
    }
}