import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<N+1; i++){
            if(N % i == 0){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}