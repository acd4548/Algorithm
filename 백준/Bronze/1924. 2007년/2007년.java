import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int month = 0;
        int date = y;
        while(month < x-1){
            month++;
            if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
                date += 31;
            }else if(month == 2){
                date += 28;
            }else{
                date += 30;
            }
        }

        if (date % 7 == 1) {
            System.out.println("MON");
        }else if (date % 7 == 2) {
            System.out.println("TUE");
        }else if (date % 7 == 3) {
            System.out.println("WED");
        }else if (date % 7 == 4) {
            System.out.println("THU");
        }else if (date % 7 == 5) {
            System.out.println("FRI");
        }else if (date % 7 == 6) {
            System.out.println("SAT");
        }else if (date % 7 == 0) {
            System.out.println("SUN");
        }
    }
}