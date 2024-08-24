import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N; i++){
            String str = br.readLine();
            if(str.length() < 6 || str.length() > 9){
                sb.append("no\n");
            }else{
                sb.append("yes\n");
            }
        }
        System.out.print(sb);
    }
}