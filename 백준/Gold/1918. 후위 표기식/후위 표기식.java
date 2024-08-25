import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> s = new Stack<>();

        String str = br.readLine();
        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);

            if(c == '+' || c == '-'){
                if(s.isEmpty() || s.peek() == '('){
                    s.add(c);
                    continue;
                }else{
                    while(true){
                        if(s.isEmpty() || s.peek() == '('){
                            s.add(c);
                            break;
                        }else{
                            sb.append(s.pop());
                        }
                    }
                }
            }else if(c == '*' || c == '/'){
                if(s.isEmpty() || s.peek() == '(' || s.peek() == '+' || s.peek() == '-'){
                    s.add(c);
                    continue;
                }else{
                    while(true){
                        if(s.isEmpty() || s.peek() == '(' || s.peek() == '+' || s.peek() == '-'){
                            s.add(c);
                            break;
                        }else{
                            sb.append(s.pop());
                        }
                    }
                }
            }else if(c == '('){
                s.add(c);
            }else if(c == ')'){
                while(s.peek() != '('){
                    sb.append(s.pop());
                }
                s.pop();
            }else{
                sb.append(c);
            }
        }
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        System.out.print(sb);

    }
}