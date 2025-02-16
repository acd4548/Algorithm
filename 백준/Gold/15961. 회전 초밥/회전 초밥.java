import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int [] sushiArr = new int [N];
        for(int i = 0; i<N; i++){
            sushiArr[i] = Integer.parseInt(br.readLine());
        }

        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i<k; i++){
            if(m.containsKey(sushiArr[i])){
                m.put(sushiArr[i], m.get(sushiArr[i]) + 1);
            }else{
                m.put(sushiArr[i], 1);
            }
        }

        int front = 0;
        int end = k;
        int max = m.size();
        if(!m.containsKey(c)){
            max++;
        }

        for(int i = 0; i<N; i++){
            if(m.get(sushiArr[front]) == 1){
                m.remove(sushiArr[front]);
            }else{
                m.put(sushiArr[front], m.get(sushiArr[front]) - 1);
            }

            if(m.containsKey(sushiArr[end])){
                m.put(sushiArr[end], m.get(sushiArr[end]) + 1);
            }else{
                m.put(sushiArr[end], 1);
            }

            int t = m.size();
            if(!m.containsKey(c)){
                t++;
            }

            max = Math.max(max, t);

            front = (front + 1) % N;
            end = (end + 1) % N;
        }

        System.out.println(max);
    }
}