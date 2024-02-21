import java.util.*;
import java.io.*;

public class Main {

    static int L, C, visited[], cntGather, cntConsonant;
    static char arr[], ans[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());    //입력받기
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char [C+1];
        visited = new int [C+1];
        ans = new char [L+1];
        cntConsonant = 0;
        cntGather = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<C+1; i++){
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
         // 여기까지 입력과 정렬해주기 !
        recur(1);
        System.out.println(sb);
    }

    private static void recur(int cur) {
        if(cur >= L+1){
            if(cntConsonant < 2 || cntGather < 1) return; // 만약 자음이 2개 미만이거나 모음이 1개미만일경우 return;
            for(int i = 1; i<L+1; i++){                   // 해당하지 않는다면 sb에 append~
                sb.append(ans[i]);
            }
            sb.append("\n");
            return;
        }

        for(int i = cur; i<C+1; i++){
            if (visited[i] == 0) {
                ans[cur] = arr[i];
                if(ans[cur-1] - '0' >= ans[cur] - '0') continue;
                visited[i] = 1;
                //이번에 들어가는 알파벳이 모음인지, 자음인지 확인하고 처리
                if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u'){
                    cntGather++;
                }else{
                    cntConsonant++;
                }
                recur(cur+1);
                //다녀오면 원상복구 ~
                visited[i] = 0;
                if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u'){
                    cntGather--;
                }else{
                    cntConsonant--;
                }
            }
        }
    }
}