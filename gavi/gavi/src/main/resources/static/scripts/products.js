//calcular valores automaticamente
document.addEventListener('DOMContentLoaded', () => {
    const cost = document.querySelector('#product-cost');
    const taxOption = document.querySelector('#product-taxes');
    const inputTaxValue = document.querySelector('#product-tax-value');
    const profit = document.querySelector('#product-profit');
    const price = document.querySelector('#product-price');

    //calcular impuestos, ganancia y precio total
    taxOption.addEventListener('change', (e) => {
        const taxSelected = taxOption.options[taxOption.selectedIndex];
        const taxRate = parseFloat(taxSelected.getAttribute('data-rate')); //se tare el atributo personalizado data-rate del HTML que contiene la tasa del impuesto
        const taxValue = parseFloat(cost.value) * taxRate;

        //agregar el valor del impuesto al input tax
        inputTaxValue.value = taxValue.toFixed(2); //para solo tener dos decimales
    })

    //calcular precio automático
    profit.addEventListener('input', (e) => {
        e.preventDefault();
        const priceValue = parseFloat(cost.value) + parseFloat(inputTaxValue.value) + parseFloat(profit.value);
        price.value = priceValue.toFixed(2); //redondea al segundo decimal
    })
})

//resetear el formulario
document.addEventListener('DOMContentLoaded', (e) => {
    e.preventDefault();
    const btnClean = document.querySelector('#btn-clean');
    const itsForm = btnClean.form;

    btnClean.addEventListener('click', () => {
        itsForm.reset();
    })
})

//temporizar el mensaje de alerta para la vista de mostrar productos
setTimeout(function() {
    let alert = document.querySelector('.alert');
    if (alert) {
        alert.style.display = 'none';
    }
}, 5000);