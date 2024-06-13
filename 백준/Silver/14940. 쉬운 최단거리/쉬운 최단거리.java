import java.util.*;
import java.io.*;
public class Main {
    static int n, m, map[][], visited[][], ans[][];
    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int [n][m];
        visited = new int [n][m];
        ans = new int [n][m];
        int r = 0;
        int c = 0;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    r = i;
                    c = j;
                }
            }
        }

        scan(r, c);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(ans[i][j] == 0 && map[i][j] == 1){
                    ans[i][j] = -1;
                }
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void scan(int r, int c){
        visited[r][c] = 1;
        Queue<int []> q = new LinkedList<>();
        q.offer(new int [] {r, c});

        while(!q.isEmpty()){
            int [] temp = q.poll();

            for(int i = 0; i<4; i++){
                int nr = temp[0] + dr[i];
                int nc = temp[1] + dc[i];

                if(nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc] == 1 || map[nr][nc] == 0) continue;
                visited[nr][nc] = 1;
                ans[nr][nc] = ans[temp[0]][temp[1]] + 1;
                q.offer(new int [] {nr, nc});
            }
        }
    }
}