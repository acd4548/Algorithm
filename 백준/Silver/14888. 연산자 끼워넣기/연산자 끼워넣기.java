import java.util.*;
import java.io.*;

public class Main {

    static int N, num[], used[], symbol[];
    static long max, min;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());    //입력받기
        num = new int [N];
        used = new int [N-1];
        symbol = new int [4];
        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;
        for(int i = 0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<4; i++){
            symbol[i] = Integer.parseInt(st.nextToken());
        }
        recur(0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void recur(int cur) {
        if(cur >= N-1){                         //기준은 기호. 기호의 idx가 N-1에 도착하면
            long temp = num[0];                 //시작은 제일 첫 숫자
            for(int i = 0; i<N-1; i++){         //계산은 처음부터 무조건 순서대로 진행하기에
                if(used[i] == 0){ // +          //used[i]가 0이면 더하기
                    temp += num[i+1];
                }else if(used[i] == 1){ // -    //used[i]가 1이면 빼기
                    temp -= num[i+1];
                }else if(used[i] == 2){ // *    //used[i]가 2이면 곱하기
                    temp *= num[i+1];
                }else { // /                    //used[i]가 3이면 나누기
                    if(temp > 0){               //나눗셈일때, 음수를 나누는 경우는 따로 처리해준다.
                        temp /= num[i+1];
                    }else if(temp < 0){
                        temp *= -1;
                        temp /= num[i+1];
                        temp *= -1;
                    }
                }
            }
            max = Math.max(temp, max);          //대소비교후 return;
            min = Math.min(temp, min);
            return;
        }

        for(int i = 0; i<4; i++){               //symbol을 처음부터 끝까지 확인하면서
            if(symbol[i] > 0){                  //연산기호가 남아있다면 사용하고 
                used[cur] = i;
                symbol[i]--;                    //하나뺴주고
                recur(cur+1);                   //다음 idx로 진행
                symbol[i]++;                    //돌아오면 다시 하나 더해준다..
            }
        }

    }
}