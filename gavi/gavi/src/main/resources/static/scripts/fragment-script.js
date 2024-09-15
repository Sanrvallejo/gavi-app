document.addEventListener("DOMContentLoaded", function() {
    const menuItems = document.querySelectorAll('.menu-item');


    menuItems.forEach(item => {
        item.addEventListener('click', function() {
            menuItems.forEach(i => i.style.backgroundColor = '');
            item.style.backgroundColor = '#015c01';
        });
    });
});