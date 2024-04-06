function solution(a, b) {
    var dates = b;
    for(let i = 1; i<a; i++){
        if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12){
            dates += 31;
        }else if(i == 2){
            dates += 29;
        }else{
            dates += 30;
        }
    }
    
    dates %= 7;
    var day = ["THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"];
    return day[dates];
    
    
    
}