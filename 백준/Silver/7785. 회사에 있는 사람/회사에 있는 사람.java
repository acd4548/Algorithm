import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeSet<String> s = new TreeSet<>();
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String state = st.nextToken();

            if(state.equals("enter")){
                s.add(name);
            }else{
                s.remove(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(String name : s){
            pq.offer(name);
        }

        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }

        System.out.print(sb);
    }
}