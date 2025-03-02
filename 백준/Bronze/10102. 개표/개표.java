import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cntA = 0;
        int cntB = 0;
        String str = br.readLine();
        for(int i = 0; i<N; i++){
            if(str.charAt(i) == 'A'){
                cntA++;
            }else{
                cntB++;
            }
        }

        if(cntA > cntB){
            System.out.println("A");
        }else if(cntA < cntB){
            System.out.println("B");
        }else{
            System.out.println("Tie");
        }
    }
}