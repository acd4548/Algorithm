function solution(s) {
    var answer = [];
    var map = new Map();
    var len = s.length;
    for(var i = 0; i < len; i++){
        var num = s[i];
        if(map.get(num) == null){
            map.set(num, i);
            answer[i] = -1;
        }else{
            var temp = 0;
            temp = i - map.get(num);
            answer[i] = temp;
            map.set(num, i);
        }
    }
    return answer;
}