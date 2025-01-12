import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        TreeSet<String> s = new TreeSet<>();
        for(int i = 0; i<str.length(); i++){
            s.add(str.substring(i));
        }

        StringBuilder sb = new StringBuilder();
        for(String t : s){
            sb.append(t).append("\n");
        }
        System.out.println(sb);
    }
}