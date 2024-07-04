import java.util.*;
import java.io.*;
public class Main {
    static boolean flag = false;
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, String> m = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            m.put(st.nextToken(), st.nextToken());
        }
        for(int i = 0; i<M; i++){
            sb.append(m.get(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }
}