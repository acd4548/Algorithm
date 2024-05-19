import java.util.*;
import java.io.*;

public class Main {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i<=N; i++){
            q.offer(i);
        }

        int size, temp;
        while(q.size() != 1){
            size = q.size();
            for(int i = 1; i<=size; i++){
                if(i % 2 == 1){
                    q.poll();
                }else{
                    temp = q.poll();
                    q.offer(temp);
                }
            }
        }

        int ans = q.poll();
        System.out.println(ans);
    }
}