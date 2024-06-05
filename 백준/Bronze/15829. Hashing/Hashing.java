import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        char [] arr = new char [L];
        String str = br.readLine();
        for(int i = 0; i<L; i++){
            arr[i] = str.charAt(i);
        }

        long ans = 0;
        long pow = 1;
        for(int i = 0; i<L; i++){
            ans += (arr[i] - 'a' + 1) * pow;
            pow = (pow * 31) % 1234567891;
        }
        System.out.println(ans % 1234567891);
    }
}