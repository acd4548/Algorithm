import java.util.*;
import java.io.*;

public class Main {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int [] arr = new int [26];
        int len = str.length();
        for(int i = 0; i<len; i++){
            arr[str.charAt(i)-'a']++;
        }

        for(int i = 0; i<26; i++){
            System.out.print(arr[i] + " ");
        }
    }
}