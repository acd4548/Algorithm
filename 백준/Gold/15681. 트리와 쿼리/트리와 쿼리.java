import java.util.*;
import java.io.*;

public class Main {
    static int N, R, Q, visited[], info[];
    static ArrayList<Integer> list [];
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        visited = new int [N+1];
        info = new int [N+1];
        list = new ArrayList[N+1];
        for(int i = 0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        visited[R] = 1;
        dfs(R);
        for(int i = 0; i<Q; i++){
            int num = Integer.parseInt(br.readLine());
            System.out.println(info[num]);
        }
    }

    static void dfs(int cur){
        info[cur] = 1;
        for(int i = 0; i<list[cur].size(); i++){
            int num = list[cur].get(i);
            if(visited[num] == 1) continue;

            visited[num] = 1;
            dfs(num);
            info[cur] += info[num];
        }
    }
}