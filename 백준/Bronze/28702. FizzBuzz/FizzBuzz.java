import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] arr = new String [3];
        for(int i = 0; i<3; i++){
            arr[i] = br.readLine();
        }

        int idx = 0;
        for(int i = 0; i<3; i++){
            if(!arr[i].equals("Fizz") && !arr[i].equals("Buzz") && !arr[i].equals("FizzBuzz")){
                idx = i;
                break;
            }
        }

        if(idx == 0){
            long num = Long.parseLong(arr[idx]) + 3;
            if(num % 3 == 0 && num % 5 == 0){
                System.out.println("FizzBuzz");
            }else if(num % 3 == 0){
                System.out.println("Fizz");
            }else if(num % 5 == 0){
                System.out.println("Buzz");
            }else{
                System.out.println(num);
            }
        }else if(idx == 1){
            long num = Long.parseLong(arr[idx]) + 2;
            if(num % 3 == 0 && num % 5 == 0){
                System.out.println("FizzBuzz");
            }else if(num % 3 == 0){
                System.out.println("Fizz");
            }else if(num % 5 == 0){
                System.out.println("Buzz");
            }else{
                System.out.println(num);
            }
        }else{
            long num = Long.parseLong(arr[idx]) + 1;
            if(num % 3 == 0 && num % 5 == 0){
                System.out.println("FizzBuzz");
            }else if(num % 3 == 0){
                System.out.println("Fizz");
            }else if(num % 5 == 0){
                System.out.println("Buzz");
            }else{
                System.out.println(num);
            }
        }
    }
}