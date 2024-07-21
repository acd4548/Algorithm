import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int N = Integer.parseInt(br.readLine());
        int num;
        for(int i = 0; i<N; i++){
            num = Integer.parseInt(br.readLine());
            if(pq.isEmpty() && num == 0){
                sb.append(0).append("\n");
            }else if(num == 0){
                sb.append(pq.poll()).append("\n");
            }else{
                pq.offer(num);
            }
        }
        System.out.println(sb);
    }
}