document.addEventListener("DOMContentLoaded", function() {
    const menuItems = document.querySelectorAll('.menu-item');


    menuItems.forEach(item => {
        item.addEventListener('click', function() {
            menuItems.forEach(i => i.style.backgroundColor = '');
            item.style.backgroundColor = '#015c01';
        });
    });
});

//resetear el formulario
document.addEventListener('DOMContentLoaded', () => {
    const btnClean = document.querySelector('#btn-clean');
    const itsForm = btnClean.form;

    btnClean.addEventListener('click', () => {
        itsForm.reset();
    })
})
