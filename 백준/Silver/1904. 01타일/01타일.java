import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int [1000010];
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i<=1000000; i++){
            arr[i] = (arr[i-1] + arr[i-2]) % 15746;
        }

        System.out.println(arr[N] % 15746);
    }
}