import java.util.*;
import java.io.*;
public class Main {
    static int box[][][], visited[][][], N, M, H, state;
    static int [] dr = {1, 0, -1, 0, 0, 0};
    static int [] dc = {0, 1, 0, -1, 0, 0};
    static int [] dh = {0, 0, 0, 0, 1, -1};
    static Queue<int []> q = new LinkedList<>();
    public static void main (String [] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int [H][N][M];
        visited = new int [H][N][M];
        state = 1;

        for(int i = 0; i<H; i++){
            for(int j = 0; j<N; j++){
                Arrays.fill(visited[i][j], 999999999);
            }
        }

        int flag = 0;
        for(int i = 0; i<H; i++){
            for(int j = 0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k<M; k++){
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k] == 1){
                        q.offer(new int [] {i, j, k, 0});
                        visited[i][j][k] = 0;
                    }else if(box[i][j][k] == -1) {
                        visited[i][j][k] = -1;
                    }else if(box[i][j][k] == 0){
                        flag = 1;
                    }
                }
            }
        }

        if(flag == 0){
            System.out.print(0);
            return;
        }

        run();
        int ans = check();
        if(ans == -1){
            System.out.println(-1);
        }else{
            System.out.print(ans);
        }
    }

    private static void run(){
        while(!q.isEmpty()){
            int [] temp = q.poll();
            for(int i = 0; i<6; i++){
                int nh = temp[0] + dh[i];
                int nr = temp[1] + dr[i];
                int nc = temp[2] + dc[i];

                if(nh < 0 || nr < 0 || nc < 0 || nh >= H || nr >= N || nc >= M) continue;

                if(visited[nh][nr][nc] <= temp[3] + 1) continue;

                visited[nh][nr][nc] = temp[3] + 1;
                q.offer(new int [] {nh, nr, nc, temp[3] + 1});
            }
        }
    }

    private static int check(){
        int max = -100;
        for(int i = 0; i<H; i++){
            for(int j = 0; j<N; j++){
                for(int k = 0; k<M; k++){
                    if(box[i][j][k] == 0 && visited[i][j][k] == 999999999){
                        return -1;
                    }
                    max = Math.max(max, visited[i][j][k]);
                }
            }
        }
        return max;
    }
}