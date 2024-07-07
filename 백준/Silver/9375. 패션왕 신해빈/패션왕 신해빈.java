import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int n;
        StringTokenizer st;
        String part;
        Map <String, Integer> m = new HashMap<>();
        for(int tc = 0; tc<T; tc++){
            n = Integer.parseInt(br.readLine());
            m.clear();

            for(int i = 0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                part = st.nextToken();
                if(m.containsKey(part)){
                    m.put(part, m.get(part) + 1);
                }else{
                    m.put(part, 1);
                }
            }

            int ans = 1;
            Iterator<String> itor = m.keySet().iterator();
            while(itor.hasNext()){
                String key = itor.next();
                int value = m.get(key);
                ans *= value + 1;
            }
            sb.append(ans-1).append("\n");
        }
        System.out.println(sb);
    }
}