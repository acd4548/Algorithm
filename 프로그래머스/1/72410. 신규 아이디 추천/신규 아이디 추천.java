import java.util.*;
class Solution {
    public String solution(String new_id) {
        return rule7(rule6(rule5(rule4(rule3(rule2(rule1(new_id)))))));
    }
    
    public String rule1(String id){
        return id.toLowerCase();
    }
    
    public String rule2(String id){
        String temp = "";
        for(int i = 0; i<id.length(); i++){
            char c = id.charAt(i);
            if(c == '-' || c == '_' || c == '.' || (c >= '0' && c <= '9') || c >= 'a' && c <= 'z'){
                temp += String.valueOf(c);
            }
        }
        return temp;
    }
    
    public String rule3(String id){
        String temp = "";
        int flag = 0;
        for(int i = 0; i<id.length(); i++){
            char c = id.charAt(i);
            if(c != '.') {
                if(flag == 1){
                    temp += ".";
                    flag = 0;
                }
                temp += String.valueOf(c);
                continue;
            }
            
            if(flag == 0){
                flag = 1;
            }
        }
        
        if(flag == 1){
            temp += ".";
        }
        return temp;
    }
    
    public String rule4(String id){
        if(id.length() == 0){
            return id;
        }
        if(id.equals(".") || id.equals("..")){
            return "";
        }else if(id.charAt(0) == '.' && id.charAt(id.length() - 1) == '.'){
            return id.substring(1, id.length() - 1);
        }else if(id.charAt(0) == '.'){
            return id.substring(1);
        }else if(id.charAt(id.length() - 1) == '.'){
            return id.substring(0, id.length() - 1);
        }else{
            return id;
        }
    }
    
    public String rule5(String id){
        if(id.equals("")){
            return "a";
        }else{
            return id;
        }
    }
    
    public String rule6(String id){
        String temp = id;
        if(id.length() >= 16){
            temp = id.substring(0, 15);
        }
        
        if(temp.charAt(temp.length() - 1) == '.'){
            temp = rule4(temp);
        }
        return temp;
    }
    
    public String rule7(String id){
        int len = id.length();
        String temp = "";
        if(len == 1){
            for(int i = 0; i<3; i++){
                temp += id;
            }
            return temp;
        }else if(len == 2){
            temp += String.valueOf(id.charAt(0));
            temp += String.valueOf(id.charAt(1));
            temp += String.valueOf(id.charAt(1));
            return temp;
        }else{
            return id;
        }
    }
}