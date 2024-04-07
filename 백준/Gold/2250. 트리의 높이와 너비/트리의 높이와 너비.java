import java.util.*;
import java.io.*;

public class Main {
    static int N, info[][], max, memo[], root;
    static ArrayList<int[]> [] list;
    static Map<Integer, int[]> m = new HashMap<>();
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        //[0] = 이 덩어리 오른쪽으론 몇까지 가있는지 [1] = 몇열 인지 저장
        info = new int [N+1][2];
        info[1][1] = 1;
        memo = new int [N+1];
        root = 0;
        max = -1;

        list = new ArrayList[N+1];
        for(int i = 0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int num, left, right;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            num = Integer.parseInt(st.nextToken());
            left = Integer.parseInt(st.nextToken());
            right = Integer.parseInt(st.nextToken());

            list[num].add(new int [] {left, right});

            if(left != -1){
                memo[left] = 1;
            }
            if(right != -1){
                memo[right] = 1;
            }
        }

        for(int i = 1; i<N+1; i++){
            if(memo[i] == 0){
                root = i;
            }
        }

        dfs(root, 1);

        int ans [] = {-1, -1}; //[0] = 넓이 몇인지, [1] = 레벨몇인지
        for(int i = 1; i<max+1; i++){
            int l = m.get(i)[0];
            int r = m.get(i)[1];
//            System.out.println(i + " " + l + " " + r);

            int temp = info[r][1] - info[l][1] + 1;
            if(ans[0] < temp){
                ans[0] = temp;
                ans[1] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ans[1]).append(" ").append(ans[0]);
        System.out.println(sb);
    }

    static void dfs(int cur, int depth){
        int arr [] = list[cur].get(0);
        max = Math.max(depth, max);

        if(arr[0] != -1){
            info[arr[0]][1] = info[cur][1];
            dfs(arr[0], depth+1);
            if(info[arr[0]][0] != 0){
                info[cur][1] = info[arr[0]][0] + 1;
            }else{
                info[cur][1] = info[arr[0]][1] + 1;
            }
        }

        if(arr[1] != -1){
            info[arr[1]][1] = info[cur][1] + 1;
            dfs(arr[1], depth+1);
            if(info[arr[1]][0] != 0){
                info[cur][0] = info[arr[1]][0];
            }else{
                info[cur][0] = info[arr[1]][1];
            }
        }

        if(m.get(depth) == null){
            m.put(depth, new int [] {cur, cur});
        }else{
            int temp [] = m.get(depth);
            if(info[temp[0]][1] > info[cur][1]){
                temp[0] = cur;
            }
            if(info[temp[1]][1] < info[cur][1]){
                temp[1] = cur;
            }
            m.put(depth, temp);
        }
    }
}