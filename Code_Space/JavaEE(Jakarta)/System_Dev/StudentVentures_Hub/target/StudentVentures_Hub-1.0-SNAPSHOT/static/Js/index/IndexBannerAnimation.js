document.addEventListener("DOMContentLoaded", function () {

    const bannerWrapper = document.querySelector('#Banner');

    let currentIndex = 0;

    function changeBanner(index) {
        const bannerWidth = document.querySelector('.Banner_Content').clientWidth;
        bannerWrapper.style.transform = `translateX(${-index * bannerWidth}px)`;
    }

    function nextBanner() {
        currentIndex = (currentIndex + 1) % document.querySelectorAll('.Banner_Content').length;
        changeBanner(currentIndex);
    }

    function pervBanner() {
        currentIndex = (currentIndex - 1 + document.querySelectorAll('.Banner_Content').length) % document.querySelectorAll('.Banner_Content').length;
        changeBanner(currentIndex);
    }

    document.getElementById('banner_help').addEventListener('click',function (){
        window.location.href="Page_Help&Inquire/20231121_help&inquire.html";
    });
    document.getElementById('banner_attend').addEventListener('click',function () {
        document.getElementById('AttendNavbarBtn').click();
    });
    document.getElementById('JoinUs').addEventListener('click',function (){
        window.location.href="Robo_Fraternity_Club.html";
    });

    document.getElementById('NextBanner').addEventListener('click',function (){
        nextBanner();
    });

    document.getElementById('PervBanner').addEventListener('click',function (){
        pervBanner();
    });

    setInterval(nextBanner, 4000);

});