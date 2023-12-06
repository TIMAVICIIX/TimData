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

    document.getElementById('NextBanner').addEventListener('click',function (){
        nextBanner();
    });

    document.getElementById('PervBanner').addEventListener('click',function (){
        pervBanner();
    });

    setInterval(nextBanner, 4000);

});