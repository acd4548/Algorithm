import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        long [] arr = new long [N];
        long [] origin = new long [N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
            origin[i] = arr[i];
        }

        Arrays.sort(arr);

        Map<Long, Long> m = new HashMap<>();
        int before = 0;
        m.put(arr[0], 0L);
        for(int i = 1; i<N;i++){
            if(!m.containsKey(arr[i])){
                m.put(arr[i], before+1L);
                before++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N; i++){
            sb.append(m.get(origin[i])).append(" ");
        }
        System.out.print(sb);
    }
}