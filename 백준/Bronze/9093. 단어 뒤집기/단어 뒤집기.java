import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int temp = st.countTokens();
            for(int j = 0; j<temp; j++){
                StringBuilder str = new StringBuilder(st.nextToken());
                sb.append(str.reverse()).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }
}