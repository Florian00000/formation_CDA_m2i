const fs = require('fs');

let content = fs.readFileSync(process.argv[2], {encoding: 'utf-8'});
let count = content.split('\n').length - 1;
console.log(count);
