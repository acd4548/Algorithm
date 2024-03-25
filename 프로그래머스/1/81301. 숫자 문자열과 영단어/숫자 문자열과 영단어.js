function solution(s) {
    var answer = s;
    var strs = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];
    for(var i = 0; i<strs.length; i++){
        var news = answer.split(strs[i]);
        answer = news.join(i);
    }
    return Number(answer);
}