$(document).ready(function(){

    $.getJSON( "/rate={rate}" , function(data) {


        let url = window.location.href;

        let toRate=url.substr(url.length-3);

        let rate;
        let some;

        $('#rate').text(data.exchangeRate);
        $('#date').text(data.date);
        $('#valute').text(toRate.toUpperCase());







    });








});