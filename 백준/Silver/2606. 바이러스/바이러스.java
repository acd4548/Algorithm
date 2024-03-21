import java.util.*;
import java.io.*;

public class Main {
    static int visited[], info[][], cnt;
    static List<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        visited = new int [N+1];
        cnt = 0;

        for(int i = 0; i<N+1; i++){
            list.add(new ArrayList<Integer>());
        }

        for(int i = 0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        dfs(1);
        System.out.println(cnt);
    }

    static void dfs(int n){
        int len = list.get(n).size();

        visited[n] = 1;
        for(int i = 0; i<len; i++){
            int num = list.get(n).get(i);
            if(visited[num] == 1) continue;
            dfs(num);
            cnt++;
        }
    }
}