import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<str.length(); i++){
            char temp = str.charAt(i);
            if(Character.isLowerCase(temp)){
                char c = Character.toUpperCase(temp);
                sb.append(c);
            }else{
                char c = Character.toLowerCase(temp);
                sb.append(c);
            }
        }
        System.out.println(sb);
    }
}