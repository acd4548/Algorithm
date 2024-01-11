import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());
        long num = k;
        double N = Math.sqrt(k);
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 2; i<N; i++){
            while(true){
                if(k % i == 0){
                    cnt++;
                    pq.offer(i);
                    k /= i;
                }else{
                    break;
                }
            }
        }

        int arr [] = new int [pq.size()];
        long sum = 1;

        int s = pq.size();
        for(int i = 0; i<s; i++){
            arr[i] = pq.poll();
            sum *= arr[i];
        }

        if(sum == num){
            System.out.println(s);
            for(int i = 0; i<s; i++){
                System.out.print(arr[i] + " ");
            }
        }else{
            System.out.println(s+1);
            for(int i = 0; i<s; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println(num / sum);
        }
    }
}