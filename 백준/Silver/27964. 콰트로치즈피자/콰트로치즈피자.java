import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> s = new HashSet<>();
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<num; i++){
            String str = st.nextToken();
            if(check(str)){
                s.add(str);
            }
        }

        if(s.size() >= 4){
            System.out.println("yummy");
        }else{
            System.out.println("sad");
        }
    }

    private static boolean check(String str){
        int len = str.length();
        if(len < 6) return false;
        if(str.charAt(len - 1) != 'e' || str.charAt(len - 2) != 's' || str.charAt(len - 3) != 'e' || str.charAt(len - 4) != 'e' || str.charAt(len - 5) != 'h' || str.charAt(len - 6) != 'C'){
            return false;
        }
        return true;
    }
}