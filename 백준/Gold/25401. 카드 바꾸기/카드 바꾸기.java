import java.util.*;
import java.io.*;
public class Main {
    static int N, arr[];
    static int [] way = {-1, 1};
    static Queue<int []> q = new LinkedList<>();
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        arr = new int [N];
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int num;
        int ans = 600;
        for(int i = 0; i<N-1; i++){
            num = arr[i] - arr[i+1];
            q.clear();
            ans = Math.min(ans, check(num, i));
        }
        System.out.println(ans);
    }

    static int check(int dif, int idx){
        //나 지금 몇번째 idx인지, 지금 몇인지
        q.offer(new int [] {idx, arr[idx]});
        int cnt = 0;
        int [] visited = new int [N];
        visited[idx] = 1;

        while(!q.isEmpty()){
            int temp [] = q.poll();

            for(int i = 0; i<2; i++){
                int nIdx = temp[0] + way[i];

                if(nIdx < 0 || nIdx >= N || visited[nIdx] == 1) continue;

                visited[nIdx] = 1;
                if(i == 0){
                    int num = arr[nIdx] - temp[1];
                    if(num == dif){
                        q.offer(new int [] {nIdx, arr[nIdx]});
                    }else{
                        cnt++;
                        q.offer(new int [] {nIdx, arr[temp[0]] + dif});
                    }
                }else{
                    int num = temp[1] - arr[nIdx];
                    if(num == dif){
                        q.offer(new int [] {nIdx, arr[nIdx]});
                    }else{
                        cnt++;
                        q.offer(new int [] {nIdx, arr[temp[0]] - dif});
                    }
                }
            }
        }

        return cnt;
    }
}