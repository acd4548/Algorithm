import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int M = Integer.parseInt(br.readLine());
        String str;
        int num = 0;
        StringBuilder sb = new StringBuilder();
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            str = st.nextToken();
            if(!str.equals("all") && !str.equals("empty")){
                num = Integer.parseInt(st.nextToken());
            }

            if(str.equals("add")){
                if(!s.contains(num)){
                    s.add(num);
                }
            }else if(str.equals("remove")){
                if(s.contains(num)){
                    s.remove(num);
                }
            }else if(str.equals("check")){
                if(s.contains(num)){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else if(str.equals("toggle")){
                if(s.contains(num)){
                    s.remove(num);
                }else{
                    s.add(num);
                }
            }else if(str.equals("all")){
                s.clear();
                for(int j = 1; j<=20; j++){
                    s.add(j);
                }
            }else if(str.equals("empty")){
                s.clear();
            }
        }
        System.out.print(sb);
    }
}