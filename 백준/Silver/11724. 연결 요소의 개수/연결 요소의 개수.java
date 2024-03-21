import java.util.*;
import java.io.*;

public class Main {
    static int visited[], cnt;
    static ArrayList<Integer>[] list;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new int [N+1];
        cnt = 0;
        list = new ArrayList[N+1];

        for(int i = 1; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 1; i<N+1; i++){
            if(visited[i] == 0){
                cnt++;
                dfs(i);
            }
        }
        System.out.println(cnt);
    }

    static void dfs(int n){
        visited[n] = 1;

        int len = list[n].size();
        for(int i = 0; i<len; i++){
            int temp = list[n].get(i);
            if(visited[temp] == 1) continue;

            dfs(temp);
        }
    }
}