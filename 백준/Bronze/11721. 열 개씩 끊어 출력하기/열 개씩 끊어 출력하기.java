import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        int len = str.length();
        int idx = 0;
        int cnt = 0;
        while(idx < len){
            sb.append(str.charAt(idx++));
            cnt++;
            if(cnt == 10){
                sb.append("\n");
                cnt = 0;
            }
        }
        System.out.println(sb);
    }
}