let res = 0 ;

for (let index = 2; index < process.argv.length; index++) {
    res += parseInt(process.argv[index]);    
}
console.log(res);