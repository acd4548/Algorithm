import java.util.*;
import java.io.*;

public class Main {

    static int map[][], visited[][], N, M;
    static int dc[] = {-1, 0, 1, 0};
    static int dr[] = {0, 1, 0, -1};

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int [N+2][M+2];
        visited = new int [N+2][M+2];

        for(int i = 1; i<N+1; i++){
            String str = br.readLine();
            for(int j = 1; j<M+1; j++){
                map[i][j] = str.charAt(j-1) - '0';
            }
        }

        bfs();
    }

    private static void bfs(){
        Queue<int []> q = new LinkedList<>();

        q.offer(new int [] {1, 1, 1});
        visited[1][1] = 1;

        while(!q.isEmpty()){
            int [] info = q.poll();

            int r = info[0];
            int c = info[1];
            int cnt = info[2];

            if(r == N && c == M){
                System.out.println(cnt);
                return;
            }

            for(int i = 0; i<4; i++){
                int nextR = r + dr[i];
                int nextC = c + dc[i];

                if(nextR < 1 || nextC < 1 || nextR > N+1 || nextC > M+1 || visited[nextR][nextC] == 1 || map[nextR][nextC] == 0) continue;

                visited[nextR][nextC] = 1;
                q.offer(new int [] {nextR, nextC, cnt+1});
            }
        }
    }
}