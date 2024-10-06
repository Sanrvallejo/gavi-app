const btnClean = document.querySelector('#btn-clean');

//resetear formulario
btnClean.addEventListener('click', () => {
    const itsForm = btnClean.form;
    itsForm.reset();
})