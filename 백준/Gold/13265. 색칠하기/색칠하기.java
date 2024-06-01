import java.util.*;
import java.io.*;
public class Main {

    static ArrayList<Integer> [] list;
    static int [] visited;
    static int n, m;
    static Queue<int []> q = new LinkedList<>();
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t<tc; t++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            visited = new int [n+1];

            list = new ArrayList[n+1];
            for(int i = 0; i<n+1; i++){
                list[i] = new ArrayList<>();
            }

            int a, b;
            for(int i = 0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }

            boolean flag = true;
            for(int i = 1; i<n+1; i++){
                if(visited[i] == 0){
                    q.clear();
                    int ans = test(i);
                    if(ans == 0){
                        sb.append("impossible").append("\n");
                        flag = false;
                        break;
                    }
                }
            }

            if(flag){
                sb.append("possible").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int test(int n){
        //[0]은 몇번째 동그라미 인지, [1]은 무슨 색인지.
        //visited의 1은 도입색, 2은 교차되는 색
        q.offer(new int [] {n, 1});
        visited[n] = 1;

        while(!q.isEmpty()){
            int [] temp = q.poll();
            int size = list[temp[0]].size();

            for(int i = 0; i<size; i++){
                int num = list[temp[0]].get(i);

                if(visited[num] == temp[1]){
                    return 0;
                }else if(visited[num] == 0){
                    if(temp[1] == 1){
                        visited[num] = 2;
                        q.offer(new int [] {num, 2});
                    }else{
                        visited[num] = 1;
                        q.offer(new int [] {num, 1});
                    }
                }
            }

        }
        return 1;
    }
}