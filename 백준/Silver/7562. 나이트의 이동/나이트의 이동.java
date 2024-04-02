import java.util.*;
import java.io.*;

public class Main {

    static int l, visited[][];

    static int dr [] = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int dc [] = {-1, -2, -2, -1, 1, 2, 2, 1};
    static Queue<int []> q = new LinkedList<>();

    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int T = 0; T<tc; T++){
            l = Integer.parseInt(br.readLine());
            visited = new int [l][l];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int stx = Integer.parseInt(st.nextToken());
            int sty = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int edx = Integer.parseInt(st.nextToken());
            int edy = Integer.parseInt(st.nextToken());
            bfs(stx, sty, edx, edy);
        }
    }

    public static void bfs(int stx, int sty, int edx, int edy){
       visited[stx][sty] = 1;
       Queue<int[]> q = new LinkedList<>();
       q.offer(new int [] {stx, sty, 0});

       while(!q.isEmpty()){
           int [] temp = q.poll();

           if(temp[0] == edx && temp[1] == edy){
               System.out.println(temp[2]);
               return;
           }

           for(int i = 0; i<8; i++){
               int nr = temp[1] + dr[i];
               int nc = temp[0] + dc[i];

               if(nr < 0 || nc < 0 || nr >= l || nc >= l || visited[nc][nr] == 1) continue;

               visited[nc][nr] = 1;
               q.offer(new int [] {nc, nr, temp[2]+1});
           }

       }
    }
}