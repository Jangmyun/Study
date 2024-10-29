# Preload 스크립트의 사용

### Preload script 란?

##### Electron module에서 Node.js 에 built-in 된 full operating system access 환경에 접근할 수 있다. 

##### renderer process는 보안상 이유로 기본적으로 node.js를 실행하지 않고 웹 페이지를 실행한다.<br/>Electron의 프로세스를 하나로 연결하려면 `preload` script가 필요하다.



### Preload script로 renderer 확장

###### ⚠️ electron 20 부터 preload script는 더이상 full node.js environ access가 불가능하다. pollyfill `require` 함수를 사용하여 한정된 API에 접근만 가능

+ Electron modules : Renderer process modules
+ Node.js modules : `events`, `timers`, `url`
+ Polyfilled globals : `Buffer`, `process`, `clearImmediate`, `setImmediate`

##### preload script는 renderer에서 웹 페이지가 로드되기 전에 실행되는데, chrome extension의 `content scripts`와 유사함

##### renderer에 features 추가하려면 `contextBridge` API 를 통해 global 객체를 정의할 수 있다.

```js
// preload.js
const { contextBridge } = require("electron");

contextBridge.exposeInMainWorld("versions", {
  node: () => process.version.node,
  chrome: () => process.versions.chrome,
  electron: () => process.versions.electron,
  // 함수 말고도 var expose 가능
});
```

##### `preload.js` script의 `process.versions` 객체를 통해 node, chrome, electron의 버전 정보를 `versions`라는 전역 변수로 노출시킨다.

```js
const { app, BrowserWindow } = require('electron')
const path = require('node:path')

const createWindow = () => {
  const win = new BrowserWindow({
    width: 800,
    height: 600,
    webPreferences: {
      preload: path.join(__dirname, 'preload.js')
    }
  })

  win.loadFile('index.html')
}

app.whenReady().then(() => {
  createWindow()
})
```

##### render process에 `preload.js` 스크립트를 추가하고 싶으면 BrowserWindow 생성자 내부의 `webPreferences.preload` 옵션을 통해 지정해 줄 수 있다.

+ `__dirname` : 현재 실행중인 스크립트의 주소 문자열
+ `path.join` : path를 합치는 api

##### 현시점에서 renderer는 `versions` global 변수에 접근이 가능하다. 



```js
// renderer.js
const information = document.getElementById('info')
information.innerText = `This app is using Chrome (v${versions.chrome()}), Node.js (v${versions.node()}), and Electron (v${versions.electron()})`
```

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta
      http-equiv="Content-Security-Policy"
      content="default-src 'self'; script-src 'self'"
    />
    <meta
      http-equiv="X-Content-Security-Policy"
      content="default-src 'self'; script-src 'self'"
    />
    <title>Hello from Electron renderer!</title>
  </head>
  <body>
    <h1>Hello from Electron renderer!</h1>
    <p>👋</p>
    <p id="info"></p>
  </body>
  <script src="./renderer.js"></script>
</html>
```

##### `renderer.js` 파일에서 `versions` 전역 변수에 접근하여 html 파일에 넣을 수 있다!

### process들 간의 상호작용

##### Electron의 renderer process와 DOM은 Node.js의 API에 직접 접근이 불가능하다.

##### inter-process communication (IPC) 프로세스 간 통신 기능으로 `ipcMain`과 `ipcRenderer` 모듈을 제공한다.

##### 웹페이지로부터 main process에 메시지를 보내려면 main process handler인  `ipcMain.handle`를 설정하고,  `ipcRenderer.invoke`로 호출할 수 있다.

```js, preload.js
const { contextBridge, ipcRenderer } = require('electron')

contextBridge.exposeInMainWorld('versions', {
  node: () => process.versions.node,
  chrome: () => process.versions.chrome,
  electron: () => process.versions.electron,
  ping: () => ipcRenderer.invoke('ping')
  // we can also expose variables, not just functions
})
```

##### `preload.js`에서 





