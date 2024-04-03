import java.io.*;
import java.util.*;

public class Main {
    static int N, M, map[][], visited[][];
    static int [] dc = {-1, 0, 1, 0};
    static int [] dr = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int [N+1][M+1];
        visited = new int [N+1][M+1];

        for(int i = 1; i<N+1; i++){
            String str = br.readLine();
            for(int j = 1; j<M+1; j++){
                map[i][j] = str.charAt(j-1) - '0';
            }
        }

        for(int i = 0; i<N+1; i++){
            Arrays.fill(visited[i], (N * M) + 10);
        }

        bfs();
        System.out.println(visited[N][M]);
    }

    static void bfs(){
        Queue<int []> q = new LinkedList<>();
        q.offer(new int [] {1, 1, 0});
        visited[1][1] = 0;

        while(!q.isEmpty()){
            int [] arr = q.poll();

            for(int i = 0; i<4; i++){
                int nc = arr[0] + dc[i];
                int nr = arr[1] + dr[i];

                if(nc < 1 || nr < 1 || nc > N || nr > M) continue;

                if(map[nc][nr] == 0){
                    if(visited[nc][nr] <= arr[2]) continue;
                    visited[nc][nr] = arr[2];
                    q.offer(new int [] {nc, nr, arr[2]});
                }else{
                    if(visited[nc][nr] <= arr[2]+1) continue;
                    visited[nc][nr] = arr[2]+1;
                    q.offer(new int [] {nc, nr, arr[2]+1});
                }
            }
        }
    }
}