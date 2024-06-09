function getCountry() {
    let phoneNumber = document.getElementById('phone').value;
    fetch("http://localhost:8088/GetCountryByPhone?phone=" + phoneNumber).then(function (response) {
        return response.json();
    }).then(function (data) {
        console.log(data);
        if (data.error == null) {
            document.getElementById('country').innerHTML = data.countryName;
        } else {
            document.getElementById('country').innerHTML = data.error;
        }
    }).catch(function (err) {
        console.log('Fetch Error :-S', err);
    });
}