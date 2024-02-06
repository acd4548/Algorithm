import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc<T; tc++){
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int [] arr = new int [N];
            for(int i = 0; i<N; i++){
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num;
                tm.put(num, num);
            }
            Arrays.sort(arr);
            int cnt = 0;
            for(int i = 0; i<N-1; i++){
                for(int j = i+1; j<N; j++){
                    int temp = Math.abs(arr[j] - arr[i]);
                    if(tm.get(arr[j] + temp) != null){
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}