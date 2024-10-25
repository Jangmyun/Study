const { app, BrowserWindow } = require("electron");
const path = require("node:path");

const createWindow = () => {
  const win = new BrowserWindow({
    width: 800,
    height: 600,
    webPreferences: {
      // nodejs의 global process object main process
      // __dirname == currently executing script
      preload: path.join(__dirname, "preload.js"), // path.join으로 디렉토리 묶기
    },
  });

  win.loadFile("index.html");
};

// app 의 ready event 가 fired 돼야지만 browser window 생성가능
app.whenReady().then(() => {
  createWindow();

  // open a window if none are open (mac)
  // app module의 activate 이벤트를 listen
  app.on("activate", () => {
    if (BrowserWindow.getAllWindows().length === 0) createWindow();
  });
});

// manage window's lifecycle
// quit app when all windows are closed (windows & linux)
app.on("window-all-closed", () => {
  if (process.platform !== "darwin") app.quit(); // darwin == MacOs
});
