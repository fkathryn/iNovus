console.log("VOTE");

function vote(id) {
    sendRequest(id, '/vote');
    location.reload();
}

function sendRequest(data, url) {
    let req = new XMLHttpRequest();
    req.open('POST', url, false);
    req.send(data);
    if (req.status !== 200) {
        console.log(req.status + " " + req.statusText);
    } else {
        console.log(req.responseText);
    }
}