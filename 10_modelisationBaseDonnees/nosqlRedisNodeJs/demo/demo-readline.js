const readline = require("readline");
const { stdin: input, stdout: output } = require("process");

const rl = readline.createInterface({ input, output });

rl.question("Merci de saisir une valeur ", (response) => {
  console.log(response);
});
