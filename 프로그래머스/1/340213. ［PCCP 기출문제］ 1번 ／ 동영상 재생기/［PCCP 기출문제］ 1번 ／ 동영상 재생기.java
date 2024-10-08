class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int now = time_to_sec(pos);
        int end = time_to_sec(video_len);
        int op_start_sec = time_to_sec(op_start);
        int op_end_sec = time_to_sec(op_end);
        if(now >= op_start_sec && now <= op_end_sec){
            now = op_end_sec;
        }
        for(int i = 0; i<commands.length; i++){
            if(commands[i].equals("next")){
                now += 10;
                if(now > end){
                    now = end;
                }
            }else{
                now -= 10;
                if(now < 0){
                    now = 0;
                }
            }
            
            if(now >= op_start_sec && now <= op_end_sec){
                now = op_end_sec;
            }
        }
        String answer = sec_to_time(now);
        return answer;
    }
    
    public static int time_to_sec(String str){
        int h = Integer.parseInt(str.substring(0, 2));
        int m = Integer.parseInt(str.substring(3, 5));
        return h * 60 + m;
    }
    
    public static String sec_to_time(int sec){
        String str = "";
        String h = String.valueOf(sec / 60);
        String m = String.valueOf(sec % 60);
        if(h.length() == 1){
            str += "0";
        }
        
        str += h;
        str += ":";
        
        if(m.length() == 1){
            str += "0";
        }
        str += m;
        return str;
    }
}