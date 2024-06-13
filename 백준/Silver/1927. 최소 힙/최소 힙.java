import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        int num;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N; i++){
            num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    sb.append(pq.poll()).append("\n");
                }
            }else{
                pq.offer(num);
            }
        }
        System.out.print(sb);
    }
}