import java.util.*;
import java.io.*;
public class Main {
    static int N, price[], clone[], sel[], visited[], min;
    static List<int[][]> list = new ArrayList<>();
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        price = new int [N];    // 실제 가격 배열
        clone = new int [N];    // 실제 가격 사본
        sel = new int [N];      // 어떤 순서로 물약을 샀는가
        visited = new int [N];  // 어떤 물약이 구매된 상탠가
        min = Integer.MAX_VALUE;// 최솟값
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){       // 가격 입력받기
            price[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<N; i++){       // 각 물약을 구매했을 때,
            int n = Integer.parseInt(br.readLine());    //할인되는 물약의 개수
            list.add(new int[n][2]);    // 할인되는 물약의 숫자와 그 비용을 넣을 배열

            for(int j = 0; j<n; j++){   // 할인되는 물약의 숫자와 그 비용 입력
                st = new StringTokenizer(br.readLine());
                list.get(i)[j][0] = Integer.parseInt(st.nextToken());
                list.get(i)[j][1] = Integer.parseInt(st.nextToken());
            }

        }

        recur(0);
        System.out.println(min);
    }

    static void recur(int cur){
        if(cur >= N){       //다 골랐다면
            //일단 clone을 (사용했던경우를 대비해 다시 price로 초기화)
            for(int i = 0; i<N; i++){
                clone[i] = price[i];
            }
            int sum = 0; // 이번 순서대로 물약을 샀을때의 비용
            for(int i = 0; i<N; i++){ // sel배열의 순서대로 구매.
                sum += clone[sel[i]];   //일단 순서대로 구매하는애의 가격을 sum에 더하고
                int len = list.get(sel[i]).length;

                //해당 물약을 구매했을 떄, 다른 물약들의 가격을 할인해준다.
                for(int j = 0; j<len; j++){
                    int [] arr = list.get(sel[i])[j];

                    clone[arr[0]-1] -= arr[1];
                    if(clone[arr[0]-1] <= 0){ // 그 값이 0이하라면 1로 바꿔주기
                        clone[arr[0]-1] = 1;
                    }
                }
            }

            //대소비교후 return
            min = Math.min(sum, min);
            return;
        }

        // 중복 확인하면서 N개의 물약을 다 골랐으면..!
        for(int i = 0; i<N; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                sel[cur] = i;
                recur(cur+1);
                visited[i] = 0;
            }
        }
    }
}