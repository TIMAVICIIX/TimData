function expandSubMenu(submenuId) {
    const submenu = document.getElementById(submenuId);
    if (submenu) {
        submenu.style.height = submenu.scrollHeight + "px";
    }
}

function collapseSubMenu(submenuId) {
    const submenu = document.getElementById(submenuId);
    if (submenu) {
        submenu.style.height = "0";
    }
}