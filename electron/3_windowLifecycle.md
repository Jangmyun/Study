# Electron에서 window의 lifecycle관리

###### os 마다 window가 다르게 작동하므로 각 os 에 맞게 동작하도록 해야한다. <br/>`BrowserWindow` module을 통해 basic window convention을 정할 수 있다.

#### Process-Specific Control Flow

##### Node.js의 `process.platform` 변수로 플랫폼에 따라 조건부로 코드를 실행할 수 있다. ( windows는 `win32`, linux는 `linux`, macos는 `darwin`)

#### 모든 윈도우가 닫혔을 때 앱 종료하기 (windows, Linux)

```js
// window-all-closed event 실행 시 app quit
app.on('window-all-closed', () => {
  if (process.platform !== 'darwin') app.quit()
})
```

##### 윈도우나 리눅스에서는 window가 모두 닫히면 app이 종료되는 방식을 취하므로 `window-all-closed` event를 listen하여 `app.quit()` 를 실행한다.

#### 열린 창이 없을 때 window 열기 (mac)

```js
app.whenReady().then(()=>{
  createWindow();

  app.on('active', () => {
    if (BrowserWindow.getAllWindow().length === 0) createWindow();
  })
})
```

##### mac에서는 창이 열려있지 않아도 앱에 동작하기 때문에 열려있는 창이 없을 때 `activate` 이벤트를 listen해서 `BrowserWindow.getAllWindows().length`이 0이면 `createWindow()`를 실행한다.



#### 전체 코드

```js
const { app, BrowserWindow } = require('electron/main')

const createWindow = () => {
  const win = new BrowserWindow({
    width: 800,
    height: 600
  })

  win.loadFile('index.html')
}

app.whenReady().then(() => {
  createWindow()

  app.on('activate', () => {
    if (BrowserWindow.getAllWindows().length === 0) {
      createWindow()
    }
  })
})

app.on('window-all-closed', () => {
  if (process.platform !== 'darwin') {
    app.quit()
  }
})
```



