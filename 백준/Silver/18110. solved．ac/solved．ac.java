import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int dif = (int)Math.round(n * 0.15);
        for(int i = 0; i<n; i++){
            dq.offer(arr[i]);
        }

        long num = 0;
        for(int i = 0; i<dif; i++){
            dq.pollFirst();
            dq.pollLast();
        }

        while(!dq.isEmpty()){
            num += dq.poll();
        }

        num = Math.round((double)num / (n - (dif * 2)));
        System.out.println(num);
    }
}