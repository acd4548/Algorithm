import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String boom = br.readLine();
        Stack<Character> s = new Stack<>();
        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c != boom.charAt(boom.length()-1)){
                s.add(c);
            }else{
                if(s.size() + 1 < boom.length()){
                    s.add(c);
                    continue;
                }
                String temp = String.valueOf(c);
                for(int j = 0; j<boom.length()-1; j++){
                    temp = String.valueOf(s.pop()) + temp;
                }

                if(!temp.equals(boom)){
                    for(int j = 0; j<temp.length(); j++){
                        s.add(temp.charAt(j));
                    }
                }
            }
        }

        if(s.size() == 0){
            System.out.print("FRULA");
            return;
        }

        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        System.out.print(sb.reverse());
    }
}