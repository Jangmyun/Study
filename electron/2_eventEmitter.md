# `EventEmmiter`란

```js
const { app, BrowserWindow } = require('electron')

const createWindow = () => {
  const win = new BrowserWindow({
    width: 800,
    height: 600
  })

  win.loadFile('index.html')
}

// app.on('ready', () => {
app.whenReady().then(() => {
  createWindow()
})
```

##### Node.js 에서 `event` == 비동기  작업이 발생했을 때 특정 동작을 실행

##### `EventEmitter` 모듈을 통해 이벤트를 생성하고 관리할 수 있다.

#### EventEmitter 주요 메서드

+ `on(event, listener)` : 특정 이벤트 발생 시 실행할 함수 등록, 이벤트 발생할 때마다 리스너(함수) 실행
+ `emit(event, [...args])` : 이벤트 발생시키고 이벤트와 연결된 리스너 호출, 호출 시 추가 인수 전달 가능
+ `once(event, listener)` ; 한 번 호출되는 리스너, 한번 실행되고 제거됨
+ `removeListener(event, listener)` : 특정 이벤트의 리스너 제거

#### 이벤트 기반 비동기 처리의 장점

##### 이벤트 기반 비동기 처리 방식으로 네트워크 요청, file i/o 등 작업에서 코드 멈춤 없이 다른 작업 진행 가능 -> 성능 효율

##### 근데 `Electron`  에서는 `ready` event 에 대해 `app.whenReady().then(listener)`를 통해 pitfall 없이 바로 listen이 가능하다.







​		