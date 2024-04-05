import java.util.*;
import java.io.*;

public class Main {
    static int N, visited[], info[];
    static ArrayList<Integer> list [];
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new int [N+1];
        info = new int [N+1];
        list = new ArrayList[N+1];
        for(int i = 0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        visited[1] = 1;
        dfs(1);
        for(int i = 2; i<N+1; i++){
            System.out.println(info[i]);
        }
    }

    static void dfs(int cur){
        for(int i = 0; i<list[cur].size(); i++){
            int num = list[cur].get(i);
            if(visited[num] == 1) continue;

            visited[num] = 1;
            info[num] = cur;
            dfs(num);
        }
    }
}