function toPadded(text, length) {
  return text.padStart(length, "0");
}

function toFormattedTime(temps) {
  const seconds = temps % 60;
  const hours = Math.floor(temps / 3600);
  const minutes = Math.floor((temps % 3600) / 60);

  const secondsToText = toPadded(seconds.toString(), 2);
  const minutesToText = toPadded(minutes.toString(), 2);
  const hoursToText = toPadded(hours.toString(), 2);

  return `${hoursToText}:${minutesToText}:${secondsToText}`;
}

function actualiseAffichageChrono(temps) {
  document.getElementById("chrono-display").textContent =
    toFormattedTime(temps);
}

let time = 0;
let lastLap;
let stopClicked = false;

function incrementTime() {
  ++time;
  actualiseAffichageChrono(time);
}

document.addEventListener("DOMContentLoaded", () => {
  let monInterval;

  document.getElementById("start-chrono").addEventListener("click", () => {
    stopClicked = false;
    document.getElementById("stop-chrono").textContent = "Stop";
    monInterval = setInterval(incrementTime, 1000);
  });

  document.getElementById("stop-chrono").addEventListener("click", () => {
    if (stopClicked) {
      time = 0;
      actualiseAffichageChrono(time);
    } else {
      clearInterval(monInterval);
      monInterval = undefined;
      stopClicked = true;
      document.getElementById("stop-chrono").textContent = "Reset";
    }
  });

  document.getElementById("lap-chrono").addEventListener("click", () => {
    stopClicked = false;
    document.getElementById("stop-chrono").textContent = "Stop";
    const newLIElement = document.createElement("li");

    const currentLap = lastLap ? time - lastLap : time;
    lastLap = time;

    newLIElement.textContent = toFormattedTime(currentLap);
    document.getElementById("chrono-listing").appendChild(newLIElement);
  });

  // console.log(`${toPadded("Toto", 10)}|${toPadded("2023-01-14", 10)}`);
  // console.log(`${toPadded("Renard", 10)}|${toPadded("2023-11-07", 10)}`);
  // console.log(`${toPadded("M2i", 10)}|${toPadded("1987-04-22", 10)}`);
});
