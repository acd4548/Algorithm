import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String st = br.readLine();
        sb.append(":fan::fan::fan:\n" + ":fan::" + st + "::fan:\n" +
                ":fan::fan::fan:");
        System.out.println(sb);
    }
}