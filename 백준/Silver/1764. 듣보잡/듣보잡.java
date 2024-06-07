import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<String> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> m = new HashMap<>();
        for(int i = 0; i<N; i++){
            m.put(br.readLine(), 1);
        }

        for(int i = 0; i<M; i++){
            String str = br.readLine();
            if(m.containsKey(str)){
                pq.offer(str);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pq.size()).append("\n");
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }
        System.out.print(sb);
    }
}