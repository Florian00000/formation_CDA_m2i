const fs = require('fs');
const path = require("path");

let filePath = process.argv[2];
let extensionFilter = process.argv[3];


function filterExtension(cheminFichier, extension) {

    let listeFiltre = [];
    
    fs.readdir(cheminFichier, (err, file) => {
        if (err) {
            console.log(err);
            return;        
        }
      for (const key in file) {       
                 
            //permet de récupérer les extensions  
            if (path.extname(file[key]) === `.${extension}`) {
                listeFiltre.push(file[key])
            } 
            
        }
        listeFiltre.forEach(f => console.log(f))
    })
}

filterExtension(filePath, extensionFilter);

// correction

// function filterByExtension(pathFile, extension) {
//     fs.readdir(pathFile, (err, files) => {
//         if(err) {
//             console.log(err.message);
//             return;
//         }

//         let filteredList = files.filter(file => path.extname(file) === `.${extension}`);
//         filteredList.forEach(f => console.log(f));
//     });
// }

// filterByExtension(filePath, extensionFilter);