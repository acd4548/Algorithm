var arr = ["aya", "ye", "woo", "ma"];

function solution(babbling) {
    var len = babbling.length;
    var answer = 0;
    for(let i = 0; i<len; i++){
        if(check(babbling[i])){
            answer++;
        }
    }
    return answer;
}

function check(str){
    var idx = 0;
    var num = 0;
    var before = -1;
    while(idx < str.length){
        num = 0;
        for(let i = 0; i<4; i++){
            var temp = arr[i];
            var tempLen = arr[i].length;
            if(str.length - idx < tempLen) {
                num++;
                continue;
            }
            var check = true;
            for(let j = 0; j<tempLen; j++){
                if(temp[j] !== str[idx+j] || i == before){
                    check = false;
                    num++;
                    break;
                }
            }
            if(check){
                idx += tempLen;
                before = i;
                break;
            }
        }
        if(num == 4) return false;
    }
    return true;
}