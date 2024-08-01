import java.util.*;
import java.io.*;
import java.util.concurrent.DelayQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        String order, array;
        int n, flag;
        Deque<Integer> dq;

        for(int tc = 0; tc<T; tc++){
            order = br.readLine();
            n = Integer.parseInt(br.readLine());
            dq = new LinkedList<>();
            array = br.readLine();
            String temp = "";
            for(int i = 1; i<array.length(); i++){
                if(array.charAt(i) != ',' && array.charAt(i) != ']'){
                    temp += String.valueOf(array.charAt(i));
                }else{
                    if(temp.equals("")) break;
                    dq.offer(Integer.parseInt(temp));
                    temp = "";
                }
            }

            flag = 0; // flag가 0이면 앞 > 뒤, 1이면 뒤 > 앞
            for(int i = 0; i<order.length(); i++){
                char c = order.charAt(i);
                if(c == 'R'){
                    if(flag == 0){
                        flag = 1;
                    }else{
                        flag = 0;
                    }
                }else{
                    if(dq.isEmpty()){
                        flag = -1;
                        break;
                    }else{
                        if(flag == 0){
                            dq.pollFirst();
                        }else{
                            dq.pollLast();
                        }
                    }
                }
            }

            if(flag == -1){
                sb.append("error").append("\n");
                continue;
            }

            sb.append("[");
            while(!dq.isEmpty()){
                if(flag == 0){
                    sb.append(dq.pollFirst());
                }else{
                    sb.append(dq.pollLast());
                }

                if(dq.isEmpty()){
                    break;
                }
                sb.append(",");
            }
            sb.append("]").append("\n");
        }
        System.out.print(sb);
    }
}