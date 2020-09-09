//create account
let createNewAccountButton = document.getElementById("createNewAccountButton");
let createNewAccountResponse = document.getElementById("createNewAccountResponse");
let createNewAccountNumber = document.getElementById("createNewAccountNumber");
createNewAccountButton.addEventListener('click', function () {
    fetch('/account/create', {
        method: 'POST',
        cache: 'no-cache',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            accountNumber: createNewAccountNumber.value,
        })
    })
        .then(function(response) {
            return response.json();
        })
        .then(function(jsonData) {
        })
        .catch(function(err) {
        });
})

//get balance
let getBalanceButton = document.getElementById("getBalanceButton");
let getBalanceResponse = document.getElementById("getBalanceResponse");
let getBalanceText = document.getElementById("getBalanceText");
getBalanceButton.addEventListener('click', function () {
    fetch('/balance/' + getBalanceText.value, {
        method: 'GET',
        cache: 'no-cache',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(function(response) {
        return response.json();
    })
    .then(function(jsonData) {
        getBalanceResponse.innerHTML = jsonData;
    })
    .catch(function(err) {
    });
})

// add money
let addMoneyButton = document.getElementById("addMoneyButton");
let addMoneyResponse = document.getElementById("addMoneyResponse");
let addMoneyInput = document.getElementById("addMoneyInput");
let addMoneyAccountId = document.getElementById("addMoneyAccountId")
addMoneyButton.addEventListener('click', function () {
    fetch( 'add', {
        method: 'PUT',
        cache: 'no-cache',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            accountId: addMoneyAccountId.value,
            amount: addMoneyInput.value
        })
    })
        .then(function(response) {
            return response.json();
        })
        .then(function(jsonData) {
                addMoneyResponse.innerHTML = jsonData;
        })
        .catch(function(err) {
        });
})

// take money
let takeMoneyButton = document.getElementById("takeMoneyButton");
let takeMoneyResponse = document.getElementById("takeMoneyResponse");
let takeMoneyInput = document.getElementById("takeMoneyInput");
let takeMoneyAccountId = document.getElementById("takeMoneyAccountId")
takeMoneyButton.addEventListener('click', function () {
    fetch( 'take', {
        method: 'PUT',
        cache: 'no-cache',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            accountId: takeMoneyAccountId.value,
            amount: takeMoneyInput.value
        })
    })
        .then(function(response) {
            return response.json();
        })
        .then(function(jsonData) {
                takeMoneyResponse.innerHTML = 'Added ' + jsonData[0].amount + ' to ' + jsonData[0].accountId;
        })
        .catch(function(err) {
        });
})

// transfer
let transferButton = document.getElementById("transferButton");
let transferResponse = document.getElementById("transferResponse");
let transferFromAccountId = document.getElementById("transferFromAccountId");
let transferToAccountId = document.getElementById("transferToAccountId");
let transferAmount = document.getElementById("transferAmount")
transferButton.addEventListener('click', function () {
    fetch( 'transfer', {
        method: 'PUT',
        cache: 'no-cache',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            fromAccountId: transferFromAccountId.value,
            toAccountId: transferToAccountId.value,
            amount: transferAmount.value
        })
    })
        .then(function(response) {
            return response.json();
        })
        .then(function(jsonData) {
                transferResponse.innerHTML = "";
        })
        .catch(function(err) {
        });
})

// show all accounts
let showAllAccountsButton = document.getElementById("showAllAccountsButton");
let showAllAccountsResponse = document.getElementById("showAllAccountsResponse");
showAllAccountsButton.addEventListener('click', function () {
    fetch( 'accounts', {
        method: 'GET',
        cache: 'no-cache',
        headers: {
            'Content-Type': 'application/json'
        },
    })
        .then(function(response) {
            return response.json();
        })
        .then(function(jsonData) {
            console.log(jsonData);
            let html = '';
            for (let i = 0; i < jsonData.length; i++){
                let item = jsonData[i];
                html = html + item.accountNumber +"<br>";
                console.log(item);
            }
            showAllAccountsResponse.innerHTML = html;
        })
        .catch(function(err) {
        });
})