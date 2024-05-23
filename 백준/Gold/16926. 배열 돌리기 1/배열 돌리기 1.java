import java.util.*;
import java.io.*;

public class Main {
    static int [] dr = {0, 1, 0, -1};
    static int [] dc = {1, 0, -1, 0};
    static int N, M, R, map[][];
    static Queue<int []> q = new LinkedList<>();
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int [N][M];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<R; i++){
            spin();
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void spin(){
        int [][] visited = new int [N][M];

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                int num = 0;
                if(visited[i][j] == 0){
                    q.offer(new int [] {i, j, 0});
                    num = map[i][j];
                }

                while(!q.isEmpty()){
                    int [] temp = q.poll();

                    int nr = temp[0] + dr[temp[2]];
                    int nc = temp[1] + dc[temp[2]];

                    if(nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] == 1){
                        temp[2] = (temp[2] + 1) % 4;
                        q.offer(temp);
                    }else{
                        map[temp[0]][temp[1]] = map[nr][nc];
                        visited[nr][nc] = 1;
                        if(nr == i && nc == j) {
                            map[temp[0]][temp[1]] = num;
                            break;
                        }
                        q.offer(new int [] {nr, nc, temp[2]});
                    }
                }
            }
        }
    }
}