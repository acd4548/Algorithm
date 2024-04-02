import java.util.*;
import java.io.*;
public class Main {
    static int map[][], clone[][], visited[][], N, M, time, left, ans;
    static int dc[] = {-1, 0, 1, 0};
    static int dr[] = {0, 1, 0, -1};
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        time = 0;
        left = 0;
        map = new int [N][M];
        clone = new int [N][M];
        ans = 0;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    left++;
                }
            }
        }


        mapToClone();

        while(left > 0){
            airCheck();
            melt();
            time++;
            
            if(left == 0){
                for(int i = 0; i<N; i++){
                    for(int j = 0; j<M; j++){
                        if(map[i][j] == 1){
                            ans++;
                        }
                    }
                }
            }
            cloneToMap();
        }

        System.out.println(time);
        System.out.println(ans);


    }
    static void melt(){
        Queue <int []> q = new LinkedList<>();
        for(int i = 0; i<N; i++){
            for(int j =0; j<M; j++){
                if(map[i][j] == 1){
                    q.offer(new int [] {i, j});
                }
            }
        }

        while(!q.isEmpty()){
            int [] arr = q.poll();

            for(int i = 0; i<4; i++){
                int nc = arr[0] + dc[i];
                int nr = arr[1] + dr[i];

                if(nc < 0 || nc >= N || nr < 0 || nr >= M) continue;

                if(map[nc][nr] == -1){
                    clone[arr[0]][arr[1]] = 0;
                    left--;
                    break;
                }
            }
        }
    }

    static void airCheck(){
        visited = new int [N][M];
        visited[0][0] = 1;
        Queue<int []> q = new LinkedList<>();
        q.offer(new int [] {0, 0});

        while(!q.isEmpty()){
            int arr [] = q.poll();

            for(int i = 0; i<4; i++){
                int nc = arr[0] + dc[i];
                int nr = arr[1] + dr[i];

                if(nc < 0 || nc >= N || nr < 0 || nr >= M || visited[nc][nr] == 1 || map[nc][nr] == 1) continue;

                map[nc][nr] = -1;
                visited[nc][nr] = 1;
                q.offer(new int [] {nc, nr});
            }
        }
    }

    static void mapToClone(){
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                clone[i][j] = map[i][j];
            }
        }
    }
    static void cloneToMap(){
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                map[i][j] = clone[i][j];
            }
        }
    }
}