import People from "./people.js";

document.addEventListener("DOMContentLoaded", () => {
  const myPeoples = [
    new People("John", "DUPONT", "2001-11-07"),
    new People("Clara", "MARTEZ", "1987-04-13"),
  ];

  console.log(myPeoples);

  myPeoples[0].firstname = "Titi";
  myPeoples[1].firstname = 123;

  console.log(myPeoples);

  myPeoples.forEach((p) => {
    const newLIElement = document.createElement("li");
    newLIElement.textContent = `${p.id}: ${p.fullname} (${p.birthDate})`;

    document.getElementById("result")?.appendChild(newLIElement);
  });
});
