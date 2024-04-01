import java.util.*;
import java.io.*;

public class Main {

    static int visited[], ans, N, K;
    static int move[] = {-1, 1};

    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        visited = new int [100010];
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ans = 0;
        bfs(N, 0);
        System.out.println(ans);
    }

    public static void bfs(int num, int time){
        Queue<int []> q = new LinkedList<>();
        int [] arr = {num, time};
        q.offer(arr);
        visited[num] = 1;

        while(!q.isEmpty()){
            int [] info = q.poll();
            int thisNum = info[0];
            int thisTime = info[1];

            if(thisNum == K){
                ans = thisTime;
                return;
            }
            for(int i = 0; i<3; i++){
                int nextNum = thisNum;
                if(i == 2){
                    nextNum = thisNum * 2;
                }else {
                    nextNum += move[i];
                }

                if(nextNum < 0 || nextNum > 100000 || visited[nextNum] == 1) continue;

                int [] temp = {nextNum, thisTime+1};
                visited[nextNum] = 1;
                q.offer(temp);
            }
        }
    }
}