import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String t = "aeiou";
        int ans = 0;
        for(int i = 0; i<str.length(); i++){
            if(t.contains(str.substring(i, i + 1))){
                ans++;
            }
        }
        System.out.println(ans);
    }
}