import java.util.*;
import java.io.*;

public class Main {
    static int T, N;
    static ArrayList<Integer> [] list;
    static ArrayList<Integer> listA;
    static ArrayList<Integer> listB;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc<T; tc++){
            N = Integer.parseInt(br.readLine());
            list = new ArrayList[N+1];
            for(int i = 0; i<N+1; i++){
                list[i] = new ArrayList<>();
            }

            int a, b;
            for(int i = 0; i<N-1; i++){
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                list[b].add(a);
            }

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            listA = new ArrayList<>();
            listB = new ArrayList<>();
            listA.add(a);
            listB.add(b);
            dfs(a, 1);
            dfs(b, 2);

            int idxA = listA.size();
            int idxB = listB.size();

            for(int i = 0; i<10010; i++){
                if((idxA-i-1) < 0 || (idxB-i-1) < 0 || !listA.get(idxA-i-1).equals(listB.get(idxB-i-1))){
                    System.out.println(listA.get(idxA-i));
                    break;
                }
            }
        }
    }

    static void dfs(int num, int what){
        int temp;
        if(list[num].isEmpty()) return;
        else{
            temp = list[num].get(0); // num의 조상.
        }

        if(what == 1){
            listA.add(temp);
            dfs(temp, what);
        }else{
            listB.add(temp);
            dfs(temp, what);
        }
    }
}