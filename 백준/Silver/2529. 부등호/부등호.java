import java.util.*;
import java.io.*;
public class Main {

    static int k, visited[], ans[];
    static long max, min;
    static String arr[], maxStr, minStr;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;
        maxStr = "";
        minStr = "";

        visited = new int [10]; // 0부터 9까지 방문처리할 배열
        arr = new String [k+1]; // 부등호를 표시할 배열 idx : 1~갯수
        ans = new int [k+2]; // 사용중인 숫자를 표시할 배열 idx : 1부터 갯수
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<k+1; i++){ // 부등호 입력받기
            arr[i] = st.nextToken();
        }

        recur(1);
        System.out.println(maxStr);
        System.out.println(minStr);
    }

    private static void recur(int cur){
        if(cur > k + 1){
            String str = "";
            for(int i = 1; i<k+2; i++){
                str += String.valueOf(ans[i]);
            }
            long num = Long.parseLong(str);
            if(max < num){
                max = num;
                maxStr = str;
            }
            if(min > num){
                min = num;
                minStr = str;
            }

            return;
        }

        for(int i = 0; i<10; i++){
            if(cur == 1){
                if(visited[i] == 0){
                    ans[cur] = i;
                    visited[i] = 1;
                    recur(cur+1);
                    visited[i] = 0;
                }
            }else{
                if (arr[cur - 1].equals("<")) {
                    if(ans[cur-1] >= i) continue;

                    if(visited[i] == 0){
                        ans[cur] = i;
                        visited[i] = 1;
                        recur(cur+1);
                        visited[i] = 0;
                    }
                }else{
                    if(ans[cur-1] <= i) continue;

                    if(visited[i] == 0){
                        ans[cur] = i;
                        visited[i] = 1;
                        recur(cur+1);
                        visited[i] = 0;
                    }
                }
            }
        }

    }
}