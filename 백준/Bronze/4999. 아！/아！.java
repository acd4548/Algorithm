import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String me = br.readLine();
        String doc = br.readLine();
        int lenMe = me.length();
        int lenDoc = doc.length();

        if(lenMe >= lenDoc){
            System.out.print("go");
        }else{
            System.out.print("no");
        }
    }
}