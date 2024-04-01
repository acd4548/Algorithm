import java.util.*;
import java.io.*;

public class Main {

    static int visited[][], N, M, max;
    static char map[][];
    static int dr [] = {0, 1, 0, -1};
    static int dc [] = {-1, 0, 1, 0};
    static Queue<int []> q = new LinkedList<>();

    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = -1;
        map = new char [N+2][M+2];

        for(int i = 1; i<N+1; i++){
            String str = br.readLine();
            for(int j = 1; j<M+1; j++){
                map[i][j] = str.charAt(j-1);
            }
        }

        for(int i = 1; i<N+1; i++){
            for(int j = 1; j<M+1; j++){
                if(map[i][j] == 'L'){
                    visited = new int [N+2][M+2];
                    bfs(i, j);
                }
            }
        }
        System.out.println(max);
    }

    public static void bfs(int c, int r){
        visited[c][r] = 1;
        Queue<int []> q = new LinkedList<>();
        q.offer(new int [] {c, r, 0});

        while(!q.isEmpty()){
            int [] temp = q.poll();

            max = Math.max(temp[2], max);

            for(int i = 0; i<4; i++){
                int nc = temp[0] + dc[i];
                int nr = temp[1] + dr[i];

                if(nc < 1 || nr < 1 || nc > N+1 || nr > M+1 || visited[nc][nr] == 1 || map[nc][nr] != 'L') continue;

                visited[nc][nr] = 1;
                q.offer(new int [] {nc, nr, temp[2]+1});
            }
        }
    }
}