import java.io.*;

public class Main{
    static int arr[], num[], N;
    static boolean flag = false;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        N -= 4;
        arr = new int [10];
        arr[0] = 6;
        arr[1] = 2;
        arr[2] = 5;
        arr[3] = 5;
        arr[4] = 4;
        arr[5] = 5;
        arr[6] = 6;
        arr[7] = 3;
        arr[8] = 7;
        arr[9] = 6;

        num = new int [6];
        check_sum(0);
        if(!flag) System.out.println("impossible");
    }

    private static void check_sum(int cur){
        if(flag) return;

        if(cur == 6){
            if((num[0] * 10 + num[1]) + (num[2] * 10 + num[3]) == num[4] * 10 + num[5]){
                if(check_count()){
                    StringBuilder sb = new StringBuilder();
                    for(int i = 0; i<6; i++){
                        sb.append(num[i]);
                        if(i == 1){
                            sb.append("+");
                        }else if(i == 3){
                            sb.append("=");
                        }
                    }
                    System.out.println(sb);
                    flag = true;
                    return;
                }else{
                    return;
                }
            }else{
                return;
            }
        }
        for(int i = 0; i<10; i++){
            num[cur] = i;
            check_sum(cur + 1);
            if(flag) return;
        }
    }

    private static boolean check_count(){
        int cnt = 0;
        for(int i = 0; i<6; i++){
            cnt += arr[num[i]];
        }
        if(cnt == N){
            return true;
        }else{
            return false;
        }
    }
}