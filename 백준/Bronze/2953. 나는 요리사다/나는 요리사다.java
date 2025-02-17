import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int who = 0;
        int score = 0;
        for(int i = 1; i<=5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int temp = 0;
            for(int j = 0; j<4; j++){
                temp += Integer.parseInt(st.nextToken());
            }
            if(score < temp){
                who = i;
                score = temp;
            }
        }
        System.out.println(who + " " + score);
    }
}