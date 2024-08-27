import java.util.*;
import java.io.*;
public class Main {
    static int V, max[];
    static ArrayList<int []> [] list;
    static int [] visited;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        V = Integer.parseInt(br.readLine());
        list = new ArrayList[V+1];
        for(int i = 1; i<V+1; i++) {
            list[i] = new ArrayList<>();
        }
        //간선들을 표현해주기 위한 list선언

        int s;
        StringTokenizer st;
        for(int i = 1; i<V+1; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            while(true){
                int next = Integer.parseInt(st.nextToken());
                if(next == -1){
                    break;
                }
                int len = Integer.parseInt(st.nextToken());

                list[s].add(new int [] {next, len});
            }
        }
        //여기까지가 입력

        // 트리의 지름을 구하기 위해선, 한 노드을 짚고 제일 먼곳으로 간 후,
        // 그 노드에서 다시 제일 먼곳까지의 길이를 구하면 된다.

        bfs(1);

        bfs(max[0]);
        System.out.print(max[1]);
    }

    static void bfs(int start){
        max = new int [] {-1, -1};
        visited = new int [V+1];
        visited[start] = 1;
        Queue<int []> q = new LinkedList<>();
        for(int i = 0; i<list[start].size(); i++){
            int [] temp = list[start].get(i);
            q.add(new int [] {temp[0], temp[1]});
            visited[temp[0]] = 1;
        }

        while(!q.isEmpty()){
            int [] temp = q.poll();
            if(temp[1] > max[1]){
                max[0] = temp[0];
                max[1] = temp[1];
            }

            for(int i = 0; i<list[temp[0]].size(); i++){
                int next = list[temp[0]].get(i)[0];
                if(visited[next] == 1) continue;

                visited[next] = 1;
                q.add(new int [] {next, temp[1] + list[temp[0]].get(i)[1]});
            }
        }
    }
}