import java.util.*;
import java.io.*;

public class Main {
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [][] info = new int [N][3];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
            info[i][2] = Integer.parseInt(st.nextToken());
        }
        //여기까지입력받아주는 코드

        int min = Integer.MAX_VALUE; // 최소를 비교해줄 상수
        for(int i = 0; i<N; i++){ // 각 열을 생각해서 3중포문 ! ( 힘 민첩 지능 )
            for(int j = 0; j<N; j++){
                for(int q = 0; q<N; q++){
                    int cnt = 0; // N명의 병사들중 몇명이나 이기는지 세주는 상수
                    for(int w = 0; w<N; w++){ // N명 모두 확인하면서 !
                        if((info[i][0] >= info[w][0]) && (info[j][1] >= info[w][1]) && (info[q][2] >= info[w][2])){ // 이길때
                            cnt ++; // cnt 를 1씩 증가해준다.
                        }
                    }
                    if(cnt >= K){ // 만약 최소 이겨야하는 사람수보다 크거나 같을 때
                        int sum = info[i][0] + info[j][1] + info[q][2]; // 그상태의 내 스탯을 확인하고
                        if(min > sum) { // 최소랑 비교하여 준다.
                            min = sum;
                        }
                    }
                }
            }
        }
        System.out.println(min);
    }
}