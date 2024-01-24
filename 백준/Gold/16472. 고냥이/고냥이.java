import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int [] arr = new int [26];

        int s = 0;
        int e = 0;


        int cnt = 0; // 지금 몇가지의 알파벳을 쓰고있는지
        int len = str.length(); // 주어진 문자열의 길이
        int ans = 0; // 지금 선택되고있는 문자열의 길이
        int max = -1; // 선택되고있는 문자열의 최대값

        while(s <= e && e < len){
            if(arr[str.charAt(e) - 'a'] > 0){ //이미 사용중인 애일 떄
                ans++;
                arr[str.charAt(e) - 'a']++;
                e++;
                if(max < ans){
                    max = ans;
                }
            }else{ // 처음 나온 애일 때
                if(cnt < N){        //최대한도가 남았다면
                    arr[str.charAt(e) - 'a']++;
                    cnt++;
                    ans++;
                    e++;
                    if(max < ans){
                        max = ans;
                    }
                }else{              //이미 최대한도가 꽉찼다면
                    int temp = str.charAt(s) - 'a';
                    int cntNum = 0;
                    while(arr[temp] > 0){
                        arr[str.charAt(s) - 'a']--;
                        if(arr[str.charAt(s) - 'a'] == 0){  //temp의 사용횟수가 아예 0이 될 때까지 뺴주다가 다른애들이 0이됬을 경우에 cnt--;
                            cnt--;
                            cntNum++;
                        }

                        ans--;
                        s++;
                        if(cntNum == 1){
                            break;
                        }
                    }

                    ans++;
                    cnt++;
                    arr[str.charAt(e) - 'a']++;
                    e++;
                    if(max < ans){
                        max = ans;
                    }
                }
            }
        }

        System.out.println(max);
    }
}