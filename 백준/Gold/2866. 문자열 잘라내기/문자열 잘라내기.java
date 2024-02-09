import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력 받기. ( String 2차원 배열을 만들어서 각 자리를 넣어줌.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        String [][] arr = new String[R][C];
        for(int i = 0; i<R; i++){
            String str = br.readLine();
            for(int j = 0; j<C; j++){
                arr[i][j] = String.valueOf(str.charAt(j));
            }
        }

        String [] info = new String [C];
        Arrays.fill(info, "");
        for(int i = 0; i<C; i++){
            for(int j = 0; j<R; j++){
                info[i] += arr[j][i];
            }
        }

        int count = 0; // 답안 제출용
        for(int i = 1; i<R; i++){
            TreeMap<String, Integer> tm = new TreeMap<>();

            for(int j = 0; j<C; j++){
                String str = info[j].substring(i);
                if(tm.get(str) == null){
                    tm.put(str, 1);
                }else{
                    System.out.println(count);
                    return;
                }
            }

            count++;
        }

        System.out.println(count);
    }
}