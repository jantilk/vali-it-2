//create customer
let createNewCustomerButton = document.getElementById("createNewCustomerButton");
let createNewCustomerResponse = document.getElementById("createNewCustomerResponse");
let createNewCustomerName = document.getElementById("createNewCustomerName");
let createNewCustomerUsername = document.getElementById("createNewCustomerUsername");
let createNewCustomerPassword = document.getElementById("createNewCustomerPassword");
createNewCustomerButton.addEventListener('click', function () {
    fetch('/customer/create', {
        method: 'POST',
        cache: 'no-cache',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            customerName: createNewCustomerName.value,
            username: createNewCustomerUsername.value,
            password: createNewCustomerPassword.value
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