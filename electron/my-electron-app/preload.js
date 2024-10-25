// preload script

window.addEventListener("DOMContentLoaded", () => {
  const replaceText = (selector, test) => {
    const element = document.getElementById(selector);
    if (element) element.innerHTML = text;
  };

  for (const dependency of ["chrome", "node", "electron"]) {
    replaceText(`${dependency}-version`, process.versions[dependency]);
  }
});
