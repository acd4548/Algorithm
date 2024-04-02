function solution(name, yearning, photo) {
    var answer = [];
    
    var m = new Map();
    for(let i = 0; i<name.length; i++){
        m.set(name[i], yearning[i]);
    }
    
    for(let i = 0; i<photo.length; i++){
        var point = 0;
        for(let j = 0; j<photo[i].length; j++){
            if(m.has(photo[i][j])){
                point += m.get(photo[i][j]);
            }
        }
        answer.push(point);
    }
    return answer;
}