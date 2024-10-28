const { contextBridge } = require("electron");

contextBridge.exposeInMainWorld("versions", {
  node: () => process.version.node,
  chrome: () => process.versions.chrome,
  electron: () => process.versions.electron,
  // 함수 말고도 var expose 가능
});
