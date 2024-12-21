import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append((int)(N * 0.78)).append(" ").append((int)((N * 0.2) * 0.78 + N * 0.8));
        System.out.println(sb);
    }
}