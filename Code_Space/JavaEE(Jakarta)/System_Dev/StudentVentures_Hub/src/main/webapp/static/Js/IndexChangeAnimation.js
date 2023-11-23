document.addEventListener('DOMContentLoaded', function () {

    let loginBtn = document.getElementById('LoginNavbarBtn')
    let queryBtn = document.getElementById('QueryNavbarBtn')
    let attendBtn = document.getElementById('AttendNavbarBtn')

    let loginPage=document.getElementById('Index_Login')
    let queryPage=document.getElementById('Index_Query')
    let attendPage=document.getElementById('Index_Attend')


    loginBtn.style.backgroundColor = 'rgba(180, 179, 179, 0.34)'

    loginBtn.addEventListener('click', function () {
        loginBtn.style.backgroundColor = 'rgba(180, 179, 179, 0.34)'
        queryBtn.style.backgroundColor = 'transparent'
        attendBtn.style.backgroundColor = 'transparent'

        queryPage.style.display = 'none'
        attendPage.style.display = 'none'
        loginPage.style.display = 'flex'
    })

    queryBtn.addEventListener('click', function () {
        loginBtn.style.backgroundColor = 'transparent'
        queryBtn.style.backgroundColor = 'rgba(180, 179, 179, 0.34)'
        attendBtn.style.backgroundColor = 'transparent'

        attendPage.style.display = 'none'
        loginPage.style.display = 'none'
        queryPage.style.display = 'block'
    })

    attendBtn.addEventListener('click', function () {
        loginBtn.style.backgroundColor = 'transparent'
        queryBtn.style.backgroundColor = 'transparent'
        attendBtn.style.backgroundColor = 'rgba(180, 179, 179, 0.2)'

        loginPage.style.display = 'none'
        queryPage.style.display = 'none'
        attendPage.style.display = 'block'
    })

});