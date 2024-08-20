import java.util.*;
import java.io.*;
public class Main {
    static int N, K, ans;
    static Integer visited[];
    static int [] next = {-1, 1, 2};
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ans = 0;
        visited = new Integer [100010];

        if(N == K){
            System.out.println(0);
            System.out.println(1);
            return;
        }

        bfs(N, 0);
        System.out.println(visited[K]);
        System.out.println(ans);
    }

    static void bfs(int cur, int c){
        Queue<int []> q = new LinkedList<>();
        q.offer(new int [] {cur, c});

        while(!q.isEmpty()){
            int [] temp = q.poll();

            if(temp[0] == K){
                if(visited[K] == null){
                    visited[K] = temp[1];
                    ans = 1;
                }else if(visited[K] == temp[1]){
                    ans++;
                }else{
                    continue;
                }
            }

            if(visited[temp[0]] == null || visited[temp[0]] >= temp[1]){
                visited[temp[0]] = temp[1];
            }else{
                continue;
            }

            for(int i = 0; i<3; i++){
                int num;
                if(i != 2){
                    num = temp[0] + next[i];
                }else{
                    num = temp[0] * next[i];
                }

                if(num < 0 || num > 100000) continue;

                q.offer(new int [] {num, temp[1] + 1});
            }
        }
    }
}