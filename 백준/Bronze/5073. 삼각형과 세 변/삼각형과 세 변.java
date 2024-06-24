import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int a, b, c, max, sum;
        char m;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine());
            max = 0;
            m = ' ';
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0 && c == 0){
                break;
            }
            if(max < a){
                max = a;
                m = 'a';
            }

            if(max < b){
                max = b;
                m = 'b';
            }

            if(max < c){
                max = c;
                m = 'c';
            }

            sum = 0;
            if(m == 'a'){
                sum += b + c;
            }else if(m == 'b'){
                sum += a + c;
            }else{
                sum += a + b;
            }

            if(max >= sum){
                sb.append("Invalid").append("\n");
            }else if(a == b && b == c){
                sb.append("Equilateral").append("\n");
            }else if(((a == b) && b != c) || ((b == c) && c != a) || ((c == a) && a != b)){
                sb.append("Isosceles").append("\n");
            }else{
                sb.append("Scalene").append("\n");
            }
        }
        System.out.print(sb);
    }
}