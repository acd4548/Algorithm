import java.util.*;
import java.io.*;
public class Main {
    public static void main (String [] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] nums = new int [10];
        Arrays.fill(nums, 1);
        nums[6] = 2;
        nums[9] = 2;
        String str = br.readLine();

        int ans = 1;
        for(int i = 0; i<str.length(); i++){
            int num = str.charAt(i) - '0';
            if(num == 6 || num == 9){
                nums[6]--;
                nums[9]--;
            }else{
                nums[num]--;
            }
            if(nums[num] < 0){
                for(int j = 0; j<10; j++){
                    nums[j]++;
                }
                ans++;
                nums[6]++;
                nums[9]++;
            }
        }
        System.out.print(ans);
    }
}