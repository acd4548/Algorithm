import java.util.*;
import java.io.*;

public class Main {

    static int n, k, cnt, arr[], ans[], temp;
    static boolean flag = false;
    static StringBuilder sb = new StringBuilder();

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        temp = n;
        cnt = 0;
        arr = new int [n+1];
        ans = new int [n+1];
        recur(1);
        if(sb.length() == 0){
            System.out.println(-1);
        }else{
            System.out.println(sb);
        }
    }

    private static void recur(int cur) {
        if(flag) return;                            //flag가 true면 무조건 return
        if(temp == 0){                              //temp(k)가 0이라면
            cnt++;                                  //cnt하나 더해주고
            if(cnt == k){                           //cnt 가 k와 같다면
                for(int i = 1; i<cur-1; i++){       //idx 1부터 지금 idx-1 까지 + 와함께 sb에넣어준후
                    sb.append(ans[i]).append("+");
                }
                sb.append(ans[cur-1]);              //마지막꺼 넣어주고 flag true로 바꾼다.
                flag = true;
            }
            return;
        }

        for(int i = 1; i<4; i++){                   //3 까지만 사용하니까 1~3반복문이고
            if(temp / i < 1){                       //지금 숫자(i)가 1개도 들어갈수없다면 continue;
                continue;
            }

            temp -= i;                              //그게아니면 temp(k)에 i를 뺴주고
            ans[cur] = i;                           //지금idx에 i넣어주고
            recur(cur+1);                           //다음 idx로 출발
            temp += i;                              //돌아오면 temp(k)에 i다시 더해주기
        }
    }
}