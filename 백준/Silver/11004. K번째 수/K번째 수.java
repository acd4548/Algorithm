import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<N; i++){
            pq.offer(Integer.parseInt(st.nextToken()));
        }
        for(int i = 0; i<N; i++){
            int num = pq.poll();
            if(i == K - 1){
                System.out.println(num);
                return;
            }
        }
    }
}