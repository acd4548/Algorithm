import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int ans = 0;

        HashSet<String> s = new HashSet<>();
        for(int i = 0; i<N; i++){
            s.add(br.readLine());
        }

        for(int i = 0; i<M; i++){
            String str = br.readLine();
            if(s.contains(str)){
                ans++;
            }
        }

        System.out.println(ans);
    }
}