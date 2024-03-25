function solution(begin, target, words) {
    var answer = 0;
    var visited = [];
    var queue = [];
    if(!words.includes(target)) return 0;
    
    queue.push([begin, answer]);
    
    while(queue){
        let [v, cnt] = queue.shift();
        
        if(v === target){
            return cnt;
        }
        
        words.forEach(word => {
            var notEqual = 0;
            
            if(visited.includes(word)) return;
            
            for(let i = 0; i<word.length; i++){
                if(word[i] !== v[i]){
                    notEqual++;
                }
            }
            
            if(notEqual === 1){
                queue.push([word, cnt+1]);
                visited.push(word);
            }
        })
    }
    
    return answer;
}