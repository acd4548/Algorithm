import java.util.*;
import java.io.*;

public class Main {
    static int n, m, good[], info[];
    static ArrayList<Integer> [] list;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        good = new int [n+1];
        info = new int [n+1];

        list = new ArrayList[n+1];
        for(int i = 0; i<n+1; i++){
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<n+1; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num == -1) continue;
            list[num].add(i);
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int who = Integer.parseInt(st.nextToken());
            int state = Integer.parseInt(st.nextToken());

            info[who] += state;
        }

        for(int i = 2; i<n+1; i++){
            if(info[i] != 0){
                good[i] += info[i];
                dfs(i, info[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<n+1; i++){
            sb.append(good[i]).append(" ");
        }
        System.out.println(sb);
    }

    static void dfs(int who, int state){
        for(int i = 0; i<list[who].size(); i++){
            int nxt = list[who].get(i);
            good[nxt] += state;
            dfs(nxt, state);
        }
    }
}