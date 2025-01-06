import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int [] arr = new int [10];
        for(int i = 0; i<str.length(); i++){
            arr[str.charAt(i) - '0']++;
        }

        int sum = 0;
        for(int i = 0; i<10; i++){
            sum += arr[i] * i;
        }

        if(arr[0] == 0 || sum % 3 != 0) {
            System.out.println(-1);
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i = 9; i>=0; i--){
                for(int j = 0; j<arr[i]; j++){
                    sb.append(i);
                }
            }
            System.out.println(sb);
        }
    }
}