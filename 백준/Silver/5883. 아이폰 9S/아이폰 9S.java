import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
		int [] arr = new int [N];
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0; // 얼마나 연속됬는지 세주는 수
        int tempNum = -1; // 지금 무슨 숫자가 연속되는지
        int max = Integer.MIN_VALUE; // 얼마나 연속됬는지 최댓값
        for(int i = 0; i<N; i++){ // arr 모든 숫자 확인하면서 하나씩 빼볼거야
            for(int j = 0; j<N; j++){ // arr 처음부터 끝까지 가는데 숫자가 같은 길이 세봐야겟지?
                if(arr[j] == arr[i]) continue;

                if(tempNum != arr[j]){
                    if(max < cnt) max = cnt;
                    tempNum = arr[j];
                    cnt = 0;
                }
                cnt++;
            }
            tempNum = -1;
        }
        System.out.println(max);
    }
}