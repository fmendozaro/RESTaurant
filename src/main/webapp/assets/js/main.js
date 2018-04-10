"use strict";
(function(){

    var fixedTax = 0.0625;
    var tax = 0;
    var tip = 0;

    //Events
    $(".order-item").click(function(){
        calculateTotal()
    });

    $('#tip').focusout(function(){
       calculateTotal();
    });

    function calculateTotal(){
        var subtotal = 0;
        var checkedItems = $('.order-item:checked');

        checkedItems.each(function(i, v){
            subtotal += parseInt($(v).data('price'));
        });

        tax = fixedTax * subtotal;
        tip = parseInt($('#tip').val());
        var total = subtotal + tax + tip;
        $('#subtotal').val(subtotal);
        $('#tax').val(tax);
        $('#total').val(total.toFixed(2));
    }

})();