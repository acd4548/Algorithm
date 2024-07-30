import java.util.*;
import java.io.*;
public class Main {
    public static void main (String [] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int act;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return Integer.compare(o1[0], o2[0]);
                } else {
                    return Integer.compare(o1[1], o2[1]);
                }
            }
        });

        for(int t = 0; t<N; t++){
            act = Integer.parseInt(br.readLine());

            if(act == 0){
                if(!pq.isEmpty()){
                    sb.append(pq.poll()[1]).append("\n");
                }else{
                    sb.append("0").append("\n");
                }
            }else{
                pq.offer(new int [] {Math.abs(act), act});
            }
        }
        System.out.print(sb);
    }
}