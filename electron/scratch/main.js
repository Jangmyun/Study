// import electron modules
const { app, BrowserWindow } = require("electron");
const path = require("node:path");

// reusable function to instantiate windows
const createWindow = () => {
  // load web page into a new browserWindow instance
  const win = new BrowserWindow({
    width: 800,
    height: 600,
    webPreferences: {
      preload: path.join(__dirname, "preload.js"),
    },
  });

  win.loadFile("index.html");
};

// calling function when the app is ready
app.whenReady().then(() => {
  createWindow();
});
