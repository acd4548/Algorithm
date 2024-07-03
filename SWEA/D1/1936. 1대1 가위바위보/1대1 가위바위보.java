import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(a == 1){
            if(b == 2){
                System.out.println("B");
            }else{
                System.out.println("A");
            }
        }else if(a == 2){
            if(b == 1){
                System.out.println("A");
            }else{
                System.out.println("B");
            }
        }else{
            if(b == 1){
                System.out.println("B");
            }else{
                System.out.println("A");
            }
        }
    }
}