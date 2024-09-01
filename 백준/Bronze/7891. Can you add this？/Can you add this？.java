import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            sb.append(Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken())).append("\n");
        }
        System.out.print(sb);
    }
}