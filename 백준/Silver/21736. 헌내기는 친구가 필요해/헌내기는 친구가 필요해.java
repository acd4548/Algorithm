import java.util.*;
import java.io.*;
public class Main {
    static int N, M, map[][], visited[][], cnt;
    static int [] dc = {0, 1, 0, -1};
    static int [] dr = {-1, 0, 1, 0};
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int [N][M]; // 0은 빈공간, 1은 벽, 2는 사람
        visited = new int [N][M];
        cnt = 0;

        int x = 0;
        int y = 0;

        String str;
        char c;
        for(int i = 0; i<N; i++){
            str = br.readLine();
            for(int j = 0; j<M; j++){
                c = str.charAt(j);
                if(c == 'P'){
                    map[i][j] = 2;
                }else if(c == 'X'){
                    map[i][j] = 1;
                }else if(c == 'I'){
                    y = i;
                    x = j;
                }
            }
        }

        bfs(x, y);
        if(cnt == 0){
            System.out.println("TT");
            return;
        }
        System.out.print(cnt);
    }

    static void bfs(int c, int r){
        visited[r][c] = 1;
        Queue<int []> q = new LinkedList<>();

        q.offer(new int [] {r, c});
        while(!q.isEmpty()){
            int [] temp = q.poll();

            for(int i = 0; i<4; i++){
                int nr = temp[0] + dr[i];
                int nc = temp[1] + dc[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] == 1) continue;

                visited[nr][nc] = 1;
                int next = map[nr][nc];
                if(next == 1){
                    continue;
                }else if(next == 2){
                    cnt++;
                }
                q.offer(new int [] {nr, nc});
            }
        }
    }
}