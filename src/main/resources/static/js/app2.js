$(document).ready(function () {
    $('#paymentForm').on('submit', function (e) {
        e.preventDefault();

        if (this.checkValidity() === false) {
            e.stopPropagation();
            $(this).addClass('was-validated');
            return;
        }

        let amount = $('#amount').val();
        let currency = $('#currency').val();
        let orderId = $('#orderId').val();
        let concept = $('#concept').val();
        let email = $('#email').val();

        $.ajax({
            url: '/api/payment/create',
            method: 'POST',
            data: {
                amount: amount,
                currency: currency,
                orderId: orderId,
                concept: concept,
                email: email
            },
            success: function (response) {
                $('#paymentInfo').html(`
                    <div class="alert alert-success" role="alert">
                        Pago realizado con éxito. Respuesta: ${response}
                    </div>
                `);
            },
            error: function () {
                $('#paymentInfo').html(`
                    <div class="alert alert-danger" role="alert">
                        Error al realizar el pago.
                    </div>
                `);
            }
        });
    });
});
