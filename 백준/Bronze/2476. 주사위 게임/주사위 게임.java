import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int temp = 0;
            if(a == b && b == c){
                temp = 10000 + (a * 1000);
            }else if(a == b && b != c){
                temp = 1000 + (a * 100);
            }else if(b == c && c != a){
                temp = 1000 + (b * 100);
            }else if(c == a && a != b){
                temp = 1000 + (c * 100);
            }else{
                int top = Math.max(a, b);
                top = Math.max(top, c);
                temp = top * 100;
            }
            max = Math.max(max, temp);
        }
        System.out.println(max);
    }
}