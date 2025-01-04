import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc<N; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String p = st.nextToken();

            sb.append(check(s, p)).append("\n");
        }

        System.out.println(sb);
    }

    private static int check(String s, String p){
        int st = 0;
        int len = p.length(); // 4
        int time = 0;
        while(true){
            boolean flag = true;
            for(int i = st; i<st + len; i++){
                if(st + len - 1 >= s.length()){
                    time = time + s.length() - st;
                    return time;
                }

                if(s.charAt(i) != p.charAt(i - st)){
                    time += 1;
                    st = st + 1;
                    flag = false;
                    break;
                }
            }

            if(flag){
               time++;
               st += len;
            }

            if(st >= s.length()){
                break;
            }
        }

        return time;
    }
}