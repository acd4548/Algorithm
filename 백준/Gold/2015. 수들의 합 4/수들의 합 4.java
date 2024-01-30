import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long arr [] = new long [N+1];
        long prefix[] = new long [N+1];
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i-1] + arr[i];
        }

        TreeMap<Long, Long> tm = new TreeMap<>();
        long ans = 0;

        for(int i = 0; i<N+1; i++){
            if(tm.get(prefix[i] - K) != null){
                ans += tm.get(prefix[i] - K);
            }
            if(tm.get(prefix[i]) == null){
                tm.put(prefix[i], 1L);
            }else{
                long num = tm.get(prefix[i]);
                tm.put(prefix[i], num+1);
            }
        }

        System.out.println(ans);

    }
}