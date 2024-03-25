function solution(number) {
    var answer = 0;
    var len = number.length;
    for(var i = 0; i<len-2; i++){
        for(var j = i+1; j<len-1; j++){
            for(var k = j+1; k<len; k++){
                if(number[i] + number[j] + number[k] == 0){
                    answer++;
                }
            }
        }
    }
    return answer;
}