import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        for(int i = 0; i<str.length(); i++){
            sb.append(str.charAt(i) - 'A' + 1).append(" ");
        }
        System.out.print(sb);
    }
}