import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람수
        int M = Integer.parseInt(st.nextToken()); // 파티수
        int [] trueP = new int [N+1]; // 진실을 아는지 배열
        st = new StringTokenizer(br.readLine());
        int alreadyKnowNum = Integer.parseInt(st.nextToken());
        for(int i = 0; i<alreadyKnowNum; i++){
            int temp = Integer.parseInt(st.nextToken());
            trueP[temp] = 1;
        }

        int ans = 0;
        Queue<int []> q = new LinkedList<>();
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int temp [] = new int [num];
            int flag = 0; // q에 넣어야하는지

            for(int j = 0; j<num; j++){
                int n = Integer.parseInt(st.nextToken());
                if(trueP[n] == 1) {
                    flag = 1;
                }

                temp[j] = n;
            }

            if(flag == 1){
                for(int j = 0; j<num; j++){
                    trueP[temp[j]] = 1;
                }
            }else{
                q.offer(temp);
            }
        }

        int def = q.size();
        int cnt = 0;

        if(def == 0){
            System.out.print(0);
            return;
        }

        while(true){
            int [] temp = q.poll();
            int flag = 0;

            for(int j = 0; j<temp.length; j++){
                if(trueP[temp[j]] == 1){
                    flag = 1;
                    cnt = 0;
                    def--;
                    break;
                }
            }

            if(flag == 1){
                for(int j = 0; j<temp.length; j++){
                    trueP[temp[j]] = 1;
                }
            }else{
                q.offer(temp);
                cnt++;
            }

            if(cnt == def) break;
        }

        System.out.print(q.size());
    }
}