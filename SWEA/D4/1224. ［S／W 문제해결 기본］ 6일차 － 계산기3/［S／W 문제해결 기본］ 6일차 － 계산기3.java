import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder ans;
        int num, a, b;
        String str, shift;
        char c;
        Stack<Character> s = new Stack<>();
        Stack<Integer> sNum = new Stack<>();
        for(int tc = 1; tc<=10; tc++){
            sb.append("#").append(tc).append(" ");
            num = Integer.parseInt(br.readLine());
            str = br.readLine();
            ans = new StringBuilder();
            s.clear();

            for(int i = 0; i<str.length(); i++){
                c = str.charAt(i);
                if(c == '+'){
                    if(s.isEmpty() || s.peek() == '('){
                        s.add(c);
                    }else {
                        ans.append(s.pop());
                        s.add(c);
                    }
                }else if(c == '*'){
                    if(!s.isEmpty() && s.peek() == '*'){
                        ans.append(c);
                    }else{
                        s.add(c);
                    }
                }else if(c == '('){
                    s.add(c);
                }else if(c == ')'){
                    while(s.peek() != '('){
                        ans.append(s.pop());
                    }
                    s.pop();
                }else{
                    ans.append(c);
                }
            }

            while(!s.isEmpty()){
                ans.append(s.pop());
            }

            shift = ans.toString();

            for(int i = 0; i<shift.length(); i++){
                c = shift.charAt(i);
                if(c != '*' && c != '+'){
                    sNum.add(c - '0');
                }else if(c == '*'){
                    a = sNum.pop();
                    b = sNum.pop();

                    sNum.add(a * b);
                }else{
                    a = sNum.pop();
                    b = sNum.pop();

                    sNum.add(a + b);
                }
            }
            sb.append(sNum.pop()).append("\n");
        }
        System.out.print(sb);
    }
}