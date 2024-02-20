import java.util.*;
import java.io.*;

public class Main {

    static int A, B, len, arr[], visited[], ans[];
    static long max;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        len = str.length();
        arr = new int [len];        //A를 자리수대로 저장할 배열
        visited = new int [len];    //방문처리해줄배열
        ans = new int [len];        //채택된 숫자들 저장할 배열
        for(int i = 0; i<len; i++){ //입력받아주기
            arr[i] = str.charAt(i) - '0';
        }
        A = Integer.parseInt(str);
        B = Integer.parseInt(st.nextToken());
        max = Long.MIN_VALUE;
        recur(0);

        if(max == Long.MIN_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(max);
        }
    }

    private static void recur(int cur){
        if(cur >= len){     //현재의 idx가 len보다 같거나 크면
            long num = 0;    //임시의 num을 선언하고 자리수마다 다 더하고곱해줘서
            for(int i = 0; i<len; i++){
                num += ans[i];
                if(i < len-1) num *= 10;
            }
            if(num < B){
                max = Math.max(max, num);   //대소비교하고 return
            }
            return;
        }

        for(int i = 0; i<len; i++){ // arr의 모든수 하나씩 확인하며
            if(cur == 0 && arr[i] == 0) continue; //맨첫번째자리가 0이면 continue;

            if(visited[i] == 0){    //방문x인 수라면
                ans[cur] = arr[i];  //현 자리에 그 수넣고
                visited[i] = 1; // 방문처리하고 다음자리로
                recur(cur+1);
                visited[i] = 0; // 다녀오고 방문처리 해제하기
            }
        }
    }
}