import java.util.*;
import java.io.*;

public class Main {
    static int N, info[];
    static ArrayList<int[]> list [];
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        info = new int [N+1];
        list = new ArrayList[N+1];
        for(int i = 0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new int [] {b, c});
            list[b].add(new int [] {a, c});
        }

        dfs(1, 0);
        int maxIdx = 0;
        int max = -1;
        for(int i = 0; i<N+1; i++){
            if(max < info[i]){
                max = info[i];
                maxIdx = i;
            }
        }
        Arrays.fill(info, 0);
        dfs(maxIdx, 0);
        max = -1;
        for(int i = 0; i<N+1; i++){
            max = Math.max(max, info[i]);
        }
        System.out.println(max);
    }

    static void dfs(int cur, int pre){
        for(int i = 0; i<list[cur].size(); i++){
            int [] temp = list[cur].get(i);

            if(pre == temp[0]) continue;

            info[temp[0]] += temp[1] + info[cur];
            dfs(temp[0], cur);
        }
    }
}