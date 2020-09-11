//create account
let createNewAccountButton = document.getElementById("createNewAccountButton");
let createNewAccountNumber = document.getElementById("createNewAccountNumber");
let createNewAccountBalance = document.getElementById("createNewAccountBalance");
let createNewAccountCustomerId = document.getElementById("createNewAccountCustomerId");
let createNewAccountResponse = document.getElementById("createNewAccountResponse");

createNewAccountButton.addEventListener('click', function () {
    fetch('/account/create', {
        method: 'POST',
        cache: 'no-cache',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            accountNumber: createNewAccountNumber.value,
            balance: createNewAccountBalance.value,
            customerId: createNewAccountCustomerId.value
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