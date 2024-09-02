import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer [] arr = new Integer [20010];
        StringBuilder sb = new StringBuilder();
        int front = 10000;
        int back = 10000;
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("push_back")){
                if(arr[back] != null){
                    back++;
                }
                arr[back] = Integer.parseInt(st.nextToken());
            }else if(str.equals("push_front")){
                if(arr[front] != null){
                    front--;
                }
                arr[front] = Integer.parseInt(st.nextToken());
            }else if(str.equals("pop_front")){
                if(front == back && arr[front] == null){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(arr[front]).append("\n");
                    arr[front] = null;
                    if(front != back){
                        front++;
                    }
                }
            }else if(str.equals("pop_back")){
                if(front == back && arr[front] == null){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(arr[back]).append("\n");
                    arr[back] = null;
                    if(front != back){
                        back--;
                    }
                }
            }else if(str.equals("size")){
                if(front == back && arr[front] == null){
                    sb.append(0).append("\n");
                }else if(front == back && arr[front] != null){
                    sb.append(1).append("\n");
                }else{
                    sb.append(back - front + 1).append("\n");
                }
            }else if(str.equals("empty")){
                if(front == back && arr[front] == null){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else if(str.equals("front")){
                if(front == back && arr[front] == null){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(arr[front]).append("\n");
                }
            }else if(str.equals("back")){
                if(front == back && arr[front] == null){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(arr[back]).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}