function solution(sizes) {
    var answer = 0;
    var hight = 0;
    var width = 0;
    var len = sizes.length;
    for(var i = 0; i<len; i++){
        var w = 0;
        var h = 0;
        if(sizes[i][0] >= sizes[i][1]){
            w = sizes[i][0];
            h = sizes[i][1];
        }else{
            w = sizes[i][1];
            h = sizes[i][0];
        }
        
        if(w > width) width = w;
        if(h > hight) hight = h;
        
        
    }
    answer = width * hight;
    return answer;
}