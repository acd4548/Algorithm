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
        for(int i = 0; i<L; i++){
            long num = arr[i] - 'a'+ 1;
            for(int j = 0; j<i; j++){
                num *= 31;
            }
            ans += num;
        }
        System.out.println(ans);
    }
}