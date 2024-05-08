import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int lenA = Integer.parseInt(st.nextToken());
        int lenB = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> mA = new HashMap<>();
        Map<Integer, Integer> mB = new HashMap<>();

        int num;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<lenA; i++){
            num = Integer.parseInt(st.nextToken());
            mA.put(num, 0);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<lenB; i++){
            num = Integer.parseInt(st.nextToken());
            mB.put(num, 0);
        }

        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : mA.entrySet()) {
            num = entry.getKey();
            ans += mB.getOrDefault(num, 1);
        }

        for(Map.Entry<Integer, Integer> entry : mB.entrySet()) {
            num = entry.getKey();
            ans += mA.getOrDefault(num, 1);
        }

        System.out.println(ans);
    }
}