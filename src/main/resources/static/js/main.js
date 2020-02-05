$(document).ready(function(){

    $.getJSON( "/rate={rate}" , function(data) {


        let url = window.location.href.substr(28);


        let rate;
        let some;

        $('#rate').text(data.exchangeRate);
        $('#date').text(data.date);
        $('#valute').text(url.toUpperCase());







    });








});