import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        HashSet<String> s = new HashSet<>();
        StringBuilder sb;
        for(int i = 0; i<str.length(); i++){
            sb = new StringBuilder();
            for(int j = i; j<str.length(); j++){
                sb.append(str.charAt(j));
                s.add(sb.toString());
            }
        }
        System.out.println(s.size());
    }
}