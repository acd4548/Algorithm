import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int[] dist;

    static class Node {
        int to;
        int d;

        Node(int to, int d) {
            this.to = to;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        int v1, v2, d;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            list[v1].add(new Node(v2, d));
        }

        dist = new int[N + 1];
        int [] memo = new int [N+1];
        for(int i = 1; i<N+1; i++){
            Arrays.fill(dist, 1 << 30);
            dist[i] = 0;
            visited = new boolean[N + 1];
            dikj(i);
            if(i != X){
                memo[i] += dist[X];
            }else{
                for(int j = 1; j<N+1; j++){
                    if(j == X) continue;
                    memo[j] += dist[j];
                }
            }
        }

        int max = 1 >> 30;
        for(int i = 1; i<N+1; i++){
            if(i == X) continue;
            max = Math.max(max, memo[i]);
        }
        System.out.println(max);
    }

    static void dikj(int start) {
        int min, cur, nxt, nd;
        for (int i = 0; i < N; i++) {
            min = 1 << 30;
            cur = 0;

            for (int j = 1; j < N + 1; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    cur = j;
                }
            }

            visited[cur] = true;
            for (int j = 0; j < list[cur].size(); j++) {
                nxt = list[cur].get(j).to;
                nd = dist[cur] + list[cur].get(j).d;
                dist[nxt] = Math.min(dist[nxt], nd);
            }
        }
    }
}