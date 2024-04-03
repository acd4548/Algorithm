import java.util.*;
import java.io.*;

public class Main {

    static int N, M, visited[], min, memo[];
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        memo = new int [N+1];
        for(int i = 0; i<N+1; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i = 1; i<N+1; i++){
            for(int j = 1; j<N+1; j++){
                if(i == j) continue;
                visited = new int [N+1];
                bfs(i, j);
            }
        }
        int ans = 0;
        for(int i = 1; i<N+1; i++){
            if(min > memo[i]){
                min = memo[i];
                ans = i;
            }
        }
        System.out.println(ans);
    }

    public static void bfs(int st, int ed){
        Queue<int []> q = new LinkedList<>();
        visited[st] = 1;
        for(int i = 0; i<list.get(st).size(); i++){
            int temp = list.get(st).get(i);
            q.offer(new int [] {temp, 1});
        }

        while(!q.isEmpty()){
            int arr [] = q.poll();

            if(arr[0] == ed){
                memo[st] += arr[1];
                return;
            }

            for(int i = 0; i<list.get(arr[0]).size(); i++){
                int temp = list.get(arr[0]).get(i);
                if(visited[temp] == 1) continue;
                visited[temp] = 1;
                q.offer(new int [] {temp, arr[1] + 1});
            }
        }
    }
}