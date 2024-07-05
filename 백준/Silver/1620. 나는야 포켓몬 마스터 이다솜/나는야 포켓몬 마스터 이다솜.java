import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String str;
        for(int i = 1; i<=N; i++){
            str = br.readLine();
            m1.put(i, str);
            m2.put(str, i);
        }

        String Q;
        int num;
        for(int i = 0; i<M; i++){
            Q = br.readLine();

            if(m2.containsKey(Q)){
                sb.append(m2.get(Q)).append("\n");
            }else{
                num = Integer.parseInt(Q);
                sb.append(m1.get(num)).append("\n");
            }
        }
        System.out.println(sb);
    }
}