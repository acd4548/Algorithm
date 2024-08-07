import java.util.*;
import java.io.*;
public class Main {
    static Map<Integer, Integer> map;
    public static void main (String [] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> upperPQ = new PriorityQueue<>();
        PriorityQueue<Integer> lowerPQ = new PriorityQueue<>(Collections.reverseOrder());
        int cnt;
        for(int t = 0; t<tc; t++){
            int Q = Integer.parseInt(br.readLine());
            upperPQ.clear();
            lowerPQ.clear();
            cnt = 0;
            map = new HashMap<>();
            for(int i = 0; i<Q; i++){
                st = new StringTokenizer(br.readLine());
                String act = st.nextToken();
                if(act.equals("I")){
                    int num = Integer.parseInt(st.nextToken());
                    upperPQ.offer(num);
                    lowerPQ.offer(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    cnt++;
                }else{
                    if(cnt == 0) continue;
                    int num = Integer.parseInt(st.nextToken());
                    if(num == -1){
                        delete(upperPQ);
                    }else{
                        delete(lowerPQ);
                    }
                    if(cnt > 0){
                        cnt--;
                    }
                }
            }
            if(cnt == 0){
                sb.append("EMPTY\n");
            }else{
                int temp = delete(lowerPQ);
                sb.append(temp).append(" ");
                if(map.size() > 0){
                    sb.append(delete(upperPQ));
                }else{
                    sb.append(temp);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
    private static int delete(PriorityQueue<Integer> pq){
        int num = 0;
        while(true){
            num = pq.poll();
            int temp = map.getOrDefault(num, 0);
            if(temp == 0) continue;

            if(temp == 1){
                map.remove(num);
            }else{
                map.put(num, temp - 1);
            }
            break;
        }
        return num;
    }
}