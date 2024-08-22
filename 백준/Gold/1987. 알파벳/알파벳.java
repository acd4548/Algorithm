import java.util.*;
import java.io.*;

public class Main {
    static int N, M, visited[][], max, used[];
    static char map[][];
    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람수
        M = Integer.parseInt(st.nextToken()); // 파티수
        map = new char [N][M];
        visited = new int [N][M];
        used = new int [26];
        max = 1;

        for(int i = 0; i<N; i++){
            String str = br.readLine();
            for(int j = 0; j<M; j++){
                char c = str.charAt(j);
                map[i][j] = c;
            }
        }
        visited[0][0] = 1;
        used[map[0][0] - 'A'] = 1;
        dfs(0, 0, 1);
        System.out.print(max);
    }

    static void dfs(int r, int c, int cnt){
        max = Math.max(max, cnt);

        for(int i = 0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] == 1 || used[map[nr][nc] - 'A'] == 1) continue;

            visited[nr][nc] = 1;
            used[map[nr][nc] - 'A'] = 1;
            dfs(nr, nc, cnt + 1);
            visited[nr][nc] = 0;
            used[map[nr][nc] - 'A'] = 0;
        }
    }
}