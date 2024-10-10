class Solution {
    public int[] solution(String s) {
        int [] answer = new int [2];
        StringBuilder sb;
        while(true){
            answer[0]++;
            sb = new StringBuilder();
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i) == '1'){
                    sb.append("1");
                }else{
                    answer[1]++;
                }
            }
            
            String str = sb.toString(); // 0들 제거된애
            if(str.equals("1")) break;
            int len = str.length(); // 그것의 길이. 이제 이걸 2진법으로
            s = change(len);
        }
        return answer;
    }
    
    public static String change(int len){
        String temp = "";
        
        while(len > 0){
            temp = String.valueOf(len % 2) + temp;
            len /= 2;
        }
        
        return temp;
    }
}