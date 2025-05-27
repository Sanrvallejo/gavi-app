
//temporizar el mensaje de alerta para la vista de mostrar productos
setTimeout(function() {
    let alert = document.querySelector('.alert');
    if (alert) {
        alert.style.display = 'none';
    }
}, 5000);

//resetear formulario
const btnClean = document.querySelector('#btn-clean');
btnClean.addEventListener('click', () => {
    const itsForm = btnClean.form;
    itsForm.reset();
})
