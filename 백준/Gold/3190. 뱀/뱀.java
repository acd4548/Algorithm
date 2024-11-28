import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int [][] map = new int [N+1][N+1];
        int [][] visited = new int [N+1][N+1];
        Queue<int []> q = new LinkedList<>();
        int [] st = {1, 1};
        int [] ed = {1, 1};
        int sec = 0;
        int [] dr = {0, 1, 0, -1};
        int [] dc = {1, 0, -1, 0};
        int way = 0;

        StringTokenizer stringT;
        for(int i = 0; i<K; i++){
            stringT = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(stringT.nextToken());
            int y = Integer.parseInt(stringT.nextToken());

            map[x][y] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        int [] secArr = new int [L];
        String [] wayArr = new String [L];
        int idx = 0;
        for(int i = 0; i<L; i++){
            stringT = new StringTokenizer(br.readLine());

            secArr[i] = Integer.parseInt(stringT.nextToken());
            wayArr[i] = stringT.nextToken();
        }

        visited[1][1] = 1;
        while(true){
            sec++;
            st[0] += dr[(way + 4) % 4];
            st[1] += dc[(way + 4) % 4];

            if(st[0] <= 0 || st[1] <= 0 || st[0] > N || st[1] > N || visited[st[0]][st[1]] == 1){
                break;
            }

            visited[st[0]][st[1]] = 1;
            q.offer(new int [] {st[0], st[1]});

            if(map[st[0]][st[1]] == 0){
                if(!q.isEmpty()){
                    visited[ed[0]][ed[1]] = 0;
                    int [] temp = q.poll();
                    ed[0] = temp[0];
                    ed[1] = temp[1];
                }
            }else if(map[st[0]][st[1]] == 1){
                map[st[0]][st[1]] = 0;
            }

            if(idx < L && sec == secArr[idx]){
                if(wayArr[idx].equals("D")){
                    way = (way + 1) % 4;
                }else{
                    way = (way - 1) % 4;
                }
                idx++;
            }
        }

        System.out.println(sec);
    }
}