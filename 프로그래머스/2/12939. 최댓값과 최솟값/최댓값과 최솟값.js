function solution(s) {
    var answer = '';
    var arr = s.split(' ');
    var min = Number.MAX_SAFE_INTEGER;
    var max = Number.MIN_SAFE_INTEGER;
    for(var i = 0; i<arr.length; i++){
        var num = parseInt(arr[i]);
        min = Math.min(min, num);
        max = Math.max(max, num);
    }
    
    answer = min + " " + max;
    return answer;
}