import java.util.*;
import java.io.*;
public class Solution {
    static Set<Integer> s = new HashSet<>();
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int N;
        int arr[];
        for(int tc = 1; tc<=T; tc++){
            s.clear();
            sb.append("#").append(tc).append(" ");
            N = Integer.parseInt(br.readLine());
            arr = new int [N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            s.add(0);
            for(int i = 0; i<N; i++){
                check(arr[i]);
            }
            sb.append(s.size()).append("\n");
        }
        System.out.print(sb);
    }

    private static void check(int num){
        Set<Integer> tempS = new HashSet<>();
        tempS.addAll(s);
        Iterator<Integer> it = tempS.iterator();
        while(it.hasNext()){
            s.add(it.next() + num);
        }
    }
}