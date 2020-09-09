//create customer
let createNewCustomerButton = document.getElementById("createNewCustomerButton");
let createNewCustomerResponse = document.getElementById("createNewCustomerResponse");
let createNewCustomerName = document.getElementById("createNewCustomerName");
createNewCustomerButton.addEventListener('click', function () {
    fetch('/customer/create', {
        method: 'POST',
        cache: 'no-cache',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            customerName: createNewCustomerName.value,
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
