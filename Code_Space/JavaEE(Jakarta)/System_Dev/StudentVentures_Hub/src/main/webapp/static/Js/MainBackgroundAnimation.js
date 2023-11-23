document.addEventListener("DOMContentLoaded", function () {
    const container = document.getElementById("Background_Animation_Container");

    function getRandomPosition() {

        const varLib = Math.floor(Math.random() * (100));

        if (varLib % 2 === 0) {
            const x = Math.random() * (container.offsetWidth / 2);
            return {x: x, y: container.offsetHeight};
        } else {
            const y = Math.random() * (container.offsetHeight - (container.offsetHeight / 2)) + container.offsetHeight / 2;
            return {x: -30, y: y};
        }


    }

    function createImage() {
        const image = new Image();
        image.src = "static/resources/index/air_Plane.png";
        image.classList.add("airplane");

        const {x, y} = getRandomPosition();
        image.style.left = `${x}px`;
        image.style.top = `${y}px`;

        container.appendChild(image);

        const animationDuration = 4800;

        setTimeout(() => {
            image.style.transform = `translate(${x+y}px, ${-y-20}px)`;
            image.style.opacity = "0";
        }, 50);

        setTimeout(() => {
            container.removeChild(image);
        }, animationDuration);
    }

    function startAnimation() {
        setInterval(createImage, 2000);
    }

    startAnimation();
});