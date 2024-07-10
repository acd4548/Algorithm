import java.util.*;
import java.io.*;
public class Solution {
    static int N, map[][], visited[][], cost[][];
    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = {0, 1, 0, -1};
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        String str;
        for(int tc = 1; tc<=T; tc++){
            sb.append("#").append(tc).append(" ");
            N = Integer.parseInt(br.readLine());
            map = new int [N][N];
            visited = new int [N][N];
            cost = new int [N][N];
            for(int i = 0; i<N; i++){
                str = br.readLine();
                for(int j = 0; j<N; j++){
                    map[i][j] = str.charAt(j) - '0';
                }
            }
            bfs();
            sb.append(cost[N-1][N-1]).append("\n");
        }
        System.out.print(sb);
    }


    private static void bfs(){
        Queue<int []> q = new LinkedList<>();
        q.offer(new int [] {0, 0, 0});
        visited[0][0] = 1;

        int [] temp;
        while(!q.isEmpty()){
            temp = q.poll();

            if(temp[2] > cost[temp[0]][temp[1]]) continue;

            int nr, nc, ifCost;
            for(int i = 0; i<4; i++){
                nr = temp[0] + dr[i];
                nc = temp[1] + dc[i];
                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                ifCost = temp[2] + map[nr][nc];

                if(visited[nr][nc] == 0){
                    cost[nr][nc] = ifCost;
                    visited[nr][nc] = 1;
                    q.offer(new int [] {nr, nc, ifCost});
                }else{
                    if(cost[nr][nc] > ifCost){
                        cost[nr][nc] = ifCost;
                        q.offer(new int [] {nr, nc, ifCost});
                    }
                }
            }

        }
    }
}