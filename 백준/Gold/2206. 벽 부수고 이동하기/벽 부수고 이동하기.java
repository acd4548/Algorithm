import java.io.*;
import java.util.*;

public class Main {
    static int N, M, map[][], visited[][];
    static int [] dc = {-1, 0, 1, 0};
    static int [] dr = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int [N+1][M+1];
        visited = new int [N+1][M+1];

        for(int i = 1; i<N+1; i++){
            String str = br.readLine();
            for(int j = 1; j<M+1; j++){
                map[i][j] = str.charAt(j-1) - '0';
            }
        }
        bfs();
    }

    static void bfs(){
        Queue<int []> q = new LinkedList<>();
        q.offer(new int [] {1, 1, 0, 1});
        visited[1][1] = 1;

        while(!q.isEmpty()){
            int [] arr = q.poll();

            if(arr[0] == N && arr[1] == M){
                System.out.println(arr[3]);
                return;
            }

            for(int i = 0; i<4; i++){
                int nc = arr[0] + dc[i];
                int nr = arr[1] + dr[i];

                if(nc < 1 || nr < 1 || nc > N || nr > M) continue;

                if(arr[2] == 0){ // 아직 벽 부순적 없음
                    if(visited[nc][nr] == 0){ // 한번도 지나가지 않음
                        if(map[nc][nr] == 0){
                            visited[nc][nr] = 1;
                            q.offer(new int [] {nc, nr, 0, arr[3]+1});
                        }else{
                            visited[nc][nr] = 2;
                            q.offer(new int [] {nc, nr, 1, arr[3]+1});
                        }
                    }else if(visited[nc][nr] == 1){ // 벽 부순적 없이 지나감
                        continue;
                    }else if(visited[nc][nr] == 2){ // 벽 부수고 지나감
                        if(map[nc][nr] == 0){
                            visited[nc][nr] = 1;
                            q.offer(new int [] {nc, nr, 0, arr[3]+1});
                        }else{
                            continue;
                        }
                    }
                }else{ // 벽 부순적 있음
                    if(visited[nc][nr] == 0){ // 한번도 지나가지 않음
                        if(map[nc][nr] == 0){
                            visited[nc][nr] = 2;
                            q.offer(new int [] {nc, nr, 1, arr[3]+1});
                        }else{
                            continue;
                        }
                    }else if(visited[nc][nr] == 1){ // 벽 부순적 없이 지나감
                        continue;
                    }else if(visited[nc][nr] == 2){ // 벽 부수고 지나감
                        continue;
                    }
                }

            }
        }
        System.out.println(-1);
    }
}