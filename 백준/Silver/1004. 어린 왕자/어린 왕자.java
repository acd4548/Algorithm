import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            HashMap<int[], Integer> m1 = new HashMap<>();
            HashMap<int[], Integer> m2 = new HashMap<>();

            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                int x3 = Integer.parseInt(st.nextToken());
                int y3 = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());


                if((Math.abs(x1 - x3)) * (Math.abs(x1 - x3)) + (Math.abs(y1 - y3)) * (Math.abs(y1 - y3)) < r * r){
                    int [] temp = {x3, y3, r};
                    m1.put(temp, 1);
                }

                if((Math.abs(x2 - x3)) * (Math.abs(x2 - x3)) + (Math.abs(y2 - y3)) * (Math.abs(y2 - y3)) < r * r){
                    int [] temp = {x3, y3, r};
                    m2.put(temp, 1);
                }
            }

            int ans = m1.size() + m2.size();
            for(int [] arr1 : m1.keySet()){
                for(int [] arr2 : m2.keySet()){
                    if(arr1[0] == arr2[0] && arr1[1] == arr2[1] && arr1[2] == arr2[2]){
                        ans -= 2;
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}