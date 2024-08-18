import java.util.*;
import java.io.*;

public class Main {
    static Map<Character, char[]> m = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N; i++){
            String str = br.readLine();
            m.put(str.charAt(0), new char [] {str.charAt(2), str.charAt(4)});
        }

        predfs('A');
        sb.append("\n");
        middfs('A');
        sb.append("\n");
        postdfs('A');
        System.out.print(sb);
    }

    static void predfs(char cur){
        char [] temp = m.get(cur);

        sb.append(cur);

        if(temp[0] != '.'){
            predfs(temp[0]);
        }

        if(temp[1] != '.'){
            predfs(temp[1]);
        }
    }

    static void middfs(char cur){
        char [] temp = m.get(cur);

        if(temp[0] != '.'){
            middfs(temp[0]);
        }

        sb.append(cur);

        if(temp[1] != '.'){
            middfs(temp[1]);
        }
    }

    static void postdfs(char cur){
        char [] temp = m.get(cur);

        if(temp[0] != '.'){
            postdfs(temp[0]);
        }

        if(temp[1] != '.'){
            postdfs(temp[1]);
        }

        sb.append(cur);
    }
}