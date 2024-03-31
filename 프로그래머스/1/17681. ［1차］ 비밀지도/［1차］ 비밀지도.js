function solution(n, arr1, arr2) {
    var answer = new Array(n);
    answer.fill(" ");
    
    for(let i = 0; i<arr1.length; i++){
        var num = arr1[i].toString(2).padStart(n, '0');
        var num2 = arr2[i].toString(2).padStart(n, '0');

        let line = "";
        for(let i = 0; i<n; i++){
            if(num[i] === "1" || num2[i] === "1"){
                line += "#";
            }else{
                line += " ";
            }
        }
        
        answer[i] = line;
    }
    
    return answer;
}