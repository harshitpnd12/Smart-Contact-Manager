// let currenttheme = gettheme();

// // todo

// changetheme();

// function changetheme() {
//   // document.querySelector("html").classList.add(currenttheme);
//   changepagetheme(currenttheme, currenttheme);
//   const ctb = document.querySelector("#theme_change_button");
//   ctb.querySelector("span").textContent =
//     currenttheme == "light" ? "dark" : "light";
//   const oldtheme = currenttheme;
//   ctb.addEventListener("click", (event) => {
//     if (currenttheme === "light") {
//       currenttheme = "dark";
//     } else {
//       currenttheme = "light";
//     }
//   });
// }
// // set theme
// function setTheme(currenttheme) {
//   localStorage.setItem("theme", currenttheme);
// }

// //  get theme
// function gettheme() {
//   let theme = localStorage.getItem("theme");
//   if (theme) {
//     return theme;
//   } else {
//     return "light";
//   }
// }
// function changepagetheme(theme, oldtheme) {
//   setTheme(currenttheme);
//   document.querySelector("html").classList.remove(oldtheme);
//   document.querySelector("html").classList.add(theme);
//   ctb.querySelector("span").textContent = theme == "light" ? "Dark" : "Light";
// }

// change theme work
let currentTheme = getTheme();
//initial -->

document.addEventListener("DOMContentLoaded", () => {
  changeTheme();
});

//TODO:
function changeTheme() {
  //set to web page

  changePageTheme(currentTheme, "");
  //set the listener to change theme button
  const changeThemeButton = document.querySelector("#theme_change_button");

  changeThemeButton.addEventListener("click", (event) => {
    let oldTheme = currentTheme;
    if (currentTheme === "dark") {
      //theme ko light
      currentTheme = "light";
    } else {
      //theme ko dark
      currentTheme = "dark";
    }
    console.log(currentTheme);
    changePageTheme(currentTheme, oldTheme);
  });
}

//set theme to localstorage
function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

//get theme from localstorage
function getTheme() {
  let theme = localStorage.getItem("theme");
  return theme ? theme : "light";
}

//change current page theme
function changePageTheme(theme, oldTheme) {
  //localstorage mein update karenge
  setTheme(currentTheme);
  //remove the current theme

  if (oldTheme) {
    document.querySelector("html").classList.remove(oldTheme);
  }
  //set the current theme
  document.querySelector("html").classList.add(theme);

  // change the text of button
  document
    .querySelector("#theme_change_button")
    .querySelector("span").textContent = theme == "light" ? "Dark" : "Light";
}
