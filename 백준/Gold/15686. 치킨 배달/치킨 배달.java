import java.util.*;
import java.io.*;

public class Main {
    static int N, M, map[][], info[][], visited[], min, col;
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int [N][N];
        min = Integer.MAX_VALUE;

        col = 0;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    col++;
                }
            }
        }
        info = new int [col][2];
        visited = new int [col];

        int num = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(map[i][j] == 2){
                    info[num][0] = i;
                    info[num][1] = j;
                    num++;
                }
            }
        }

        count(0, 0);
        System.out.println(min);

    }

    public static void count(int cur, int cnt){
        if(cnt == M){ // M개를 모두 고른상태
            //M개의 치킨집만을 대상으로 치킨거리  구하기
            min = Math.min(min, cel());
            return;
        }

        if(cur == col){ //M개를 다 고르지 않은 상태에서 끝까지 간 경우
            return;
        }

        visited[cur] = 1;
        count(cur+1, cnt+1);

        visited[cur] = 0;
        count(cur+1, cnt);
    }

    public static int cel(){ // 전체를 돌면서 집이면 치킨거리 구하기
        int num = 0;

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(map[i][j] == 1){
                    num += dis(i, j);
                }
            }
        }

        return num;
    }

    public static int dis(int r, int c){
        Queue<int []> q = new LinkedList<>();
        int checked [][] = new int [N][N];
        q.offer(new int [] {r, c, 0});
        checked[r][c] = 1;

        while(!q.isEmpty()){
            int temp [] = q.poll();

            if(map[temp[0]][temp[1]] == 2){
                for(int i = 0; i<col; i++){
                    if(visited[i] == 1){
                        if(temp[0] == info[i][0] && temp[1] == info[i][1]){
                            return temp[2];
                        }
                    }
                }
            }

            for(int i = 0; i<4; i++){
                int nr = temp[0] + dr[i];
                int nc = temp[1] + dc[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N || checked[nr][nc] == 1) continue;

                checked[nr][nc] = 1;
                q.offer(new int [] {nr, nc, temp[2]+1});
            }
        }
        return -10000000;
    }
}