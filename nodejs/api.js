var https = require('https');
var psw = new Buffer("21mobile:maricon").toString('base64');
var ts = Math.round((new Date()).getTime() / 1000);

var data = JSON.stringify({
  "sms": [{
    'messageText': 'Teste Integracao NodeJS',
    'destination': '51992863986'
  }]
});

var options = {
  host: 'api.21mobile.com.br',
  method: 'POST',
  path: '/v1/send',
  headers: {
    'Content-Type': 'application/json',
    'Authorization': 'Basic ' + psw,
  }
};

var httpPost = https.request(options, function (res) {

  res.setEncoding('utf8');

  console.log("response statusCode: ", res.statusCode + "\nresponse statusMessage: ", res.statusMessage);

  res.on('data', function (response) {

    console.log('Posting Result:\n');
    console.log(response);

  });
});

httpPost.end(data);

httpPost.on('error', function (e) {
  console.error(e);
});
