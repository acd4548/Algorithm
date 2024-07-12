import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        int num = 0;
        for(int i = 0; i<5; i++){
            num = Integer.parseInt(st.nextToken());
            if(num == T){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}