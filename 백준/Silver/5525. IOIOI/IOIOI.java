import java.util.*;
import java.io.*;
public class Main {
    public static void main (String [] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int len = N * 2 + 1;

        String ans = "";
        for(int i = 0; i<N; i++){
            ans += "IO";
        }
        ans += "I";

        String temp = "";
        Queue<String> q = new LinkedList<>();
        for(int i = 0; i<S.length() - len + 1; i++){
            temp = "";
            for(int j = 0; j<len; j++){
                temp += String.valueOf(S.charAt(i+j));
            }
            q.offer(temp);
        }

        int cnt = 0;
        while(!q.isEmpty()){
            if(q.poll().equals(ans)){
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}