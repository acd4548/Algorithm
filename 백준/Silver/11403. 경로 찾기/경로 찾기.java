import java.util.*;
import java.io.*;
public class Main {
    static int N, info[][],ans[][];
    static ArrayList<Integer> [] list;
    static ArrayList<Integer> [] visited;
    public static void main (String [] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        info = new int [N+1][N+1];
        ans = new int [N+1][N+1];
        list = new ArrayList[N+1];
        visited = new ArrayList[N+1];
        for(int i = 1; i<N+1; i++){
            list[i] = new ArrayList<>();
            visited[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int num;
        for(int i = 1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<N+1; j++){
                num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    list[i].add(j);
                }
            }
        }

        for(int i = 1; i<N+1; i++){
            dfs(i, i);
        }

        for(int i = 1; i<N+1; i++){
            for(int j = 1; j<N+1; j++){
                if(visited[i].contains(j)){
                    sb.append(1).append(" ");
                }else{
                    sb.append(0).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void dfs(int st, int num){
        int temp = 0;
        for(int i = 0; i<list[st].size(); i++){
            temp = list[st].get(i);
            if(!visited[num].contains(temp)){
                visited[num].add(temp);
            }else{
                continue;
            }

            if(temp == num) continue;

            dfs(temp, num);
        }

    }
}