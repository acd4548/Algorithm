import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = 1;
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            String [] arr = new String [N+1];
            for(int i = 1; i<N+1; i++){
                arr[i] = br.readLine();
            }

            HashSet<Integer> s = new HashSet<>();

            for(int i = 0; i<2 * N - 1; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(st.nextToken());
                String str = st.nextToken();

                if(s.contains(m)){
                   s.remove(m);
                }else{
                    s.add(m);
                }
            }

            int idx = 0;
            for(int t : s){
                idx = t;
            }
            sb.append(num).append(" ").append(arr[idx]).append("\n");
            num++;
        }

        System.out.println(sb);
    }
}