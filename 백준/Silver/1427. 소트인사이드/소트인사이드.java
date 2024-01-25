import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int len = N.length();
        int [] arr = new int [len];

        for(int i = 0; i<len; i++){
            arr[i] = N.charAt(i) - '0';
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<len; i++){
            sb.append(arr[i]);
        }

        System.out.println(sb.reverse());
    }
}