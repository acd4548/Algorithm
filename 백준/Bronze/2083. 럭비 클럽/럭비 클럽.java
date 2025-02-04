import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if(str.equals("#") && age == 0 && weight == 0){
                System.out.println(sb);
                return;
            }

            sb.append(str);
            if(age > 17 || weight >= 80){
                sb.append(" Senior").append("\n");
            }else{
                sb.append(" Junior").append("\n");
            }
        }
    }
}