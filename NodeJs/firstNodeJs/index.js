const express = require('express');
const app = express();

app.listen(8080, function(){
    console.log('listening on 8080');
});

app.get('/car', function(request, respond){
    respond.send('자동차 쇼핑몰임.');
})

app.get('/computer', function(request, respond){
    respond.send('컴퓨터 쇼핑몰임.');
})

app.get('/', function(request, respond){
    respond.sendFile(__dirname + '/client/index.html');
})