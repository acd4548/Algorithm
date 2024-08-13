import java.util.*;
import java.io.*;

public class Main {
    static long a, b, min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String str = br.readLine();
            if(str.equals("#")) {
                System.out.print(sb);
                break;
            }

            int cnt = 0;

            for(int i = 0; i<str.length(); i++){
                if(str.charAt(i) == 'a' || str.charAt(i) == 'e'|| str.charAt(i) == 'i'|| str.charAt(i) == 'o'|| str.charAt(i) == 'u'){
                    cnt++;
                }

                if(str.charAt(i) == 'A' || str.charAt(i) == 'E'|| str.charAt(i) == 'I'|| str.charAt(i) == 'O'|| str.charAt(i) == 'U'){
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        br.close();
    }
}