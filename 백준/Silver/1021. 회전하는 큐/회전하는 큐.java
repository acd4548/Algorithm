import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean [] visited = new boolean [N+1];

        for(int i = 1; i<N+1; i++){
            dq.offer(i);
        }

        int ans = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            int a = dq.peekFirst();
            int b = dq.peekLast();
            int aDis = 0;
            int bDis = 0;

            if(a == num){
                int t = dq.pollFirst();
                visited[t] = true;
                continue;
            }else if(b == num){
                int t = dq.pollLast();
                visited[t] = true;
                ans++;
                continue;
            }

            int temp = 0;
            if(a < num){
                for(int j = a; j<=num; j++){
                    if(visited[j]) temp++;
                }
                aDis = num - a - temp;
            }else {
                for(int j = a; j<=N; j++){
                    if(visited[j]) temp++;
                }

                for(int j = 1; j<=num; j++){
                    if(visited[j]) temp++;
                }

                aDis = (N - a) + num - temp;
            }

            temp = 0;
            if(num < b){
                for(int j = num; j<=b; j++){
                    if(visited[j]) temp++;
                }
                bDis = b - num + 1 - temp;
            }else {
                for(int j = num; j<=N; j++){
                    if(visited[j]) temp++;
                }

                for(int j = 1; j<=b; j++){
                    if(visited[j]) temp++;
                }
                bDis = (N - num + 1) + b - temp;
            }

            if(aDis < bDis){
                int t = 0;
                for(int j = 1; j<=aDis; j++){
                    t = dq.pollFirst();
                    dq.offerLast(t);
                }
                t = dq.pollFirst();
                visited[t] = true;
                ans += aDis;
            }else{
                int t = 0;
                for(int j = 1; j<=bDis; j++){
                    t = dq.pollLast();
                    dq.offerFirst(t);
                }
                t = dq.pollFirst();
                visited[t] = true;
                ans += bDis;
            }
        }

        System.out.println(ans);
    }
}