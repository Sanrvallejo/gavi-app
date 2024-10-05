//calcular valores automaticamente
document.addEventListener('DOMContentLoaded', () => {
    const cost = document.querySelector('#product-cost');
    const taxOption = document.querySelector('#product-taxes');
    const inputTaxValue = document.querySelector('#product-tax-value');
    const profit = document.querySelector('#product-profit');
    const price = document.querySelector('#product-price');
    const calculateValues = document.querySelectorAll('.calculate-values')

    //para detectar cual input es el que hace el cambio y atualizar el precio
    calculateValues.forEach(input => {
        input.addEventListener('input', () => {
            calculatePrice();
        })
    })

    //para que cuando el select cambie de impuesto se calcule nuevamente el precio
    calculateValues.forEach(select => {
        select.addEventListener('change', () => {
            calculatePrice();
        })
    })

    //calcular impuestos, ganancia y precio total
    function calculatePrice() {
        const taxSelected = taxOption.options[taxOption.selectedIndex];
        const taxRate = parseFloat(taxSelected.getAttribute('data-rate'));
        const taxValue = parseFloat(cost.value) * taxRate;//calcular el impuesto

        //imprimir el impuesto en el input
        inputTaxValue.value = taxValue.toFixed(2); //redondear a 2 decimales

        //para guardar el precio calculado
        const priceValue = parseFloat(cost.value) + parseFloat(inputTaxValue.value) + parseFloat(profit.value);
        price.value = priceValue.toFixed(2);
    }
})

//resetear el formulario
const btnClean = document.querySelector('#btn-clean');
btnClean.addEventListener('click', (e) => {
    e.preventDefault();
    const itsForm = btnClean.form;
    itsForm.reset();
})

//temporizar el mensaje de alerta para la vista de mostrar productos
setTimeout(function() {
    let alert = document.querySelector('.alert');
    if (alert) {
        alert.style.display = 'none';
    }
}, 5000);


