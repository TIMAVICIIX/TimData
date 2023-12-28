document.addEventListener('DOMContentLoaded', function () {
    function updateRefreshTime() {
        const currentTime = new Date();

        const year = currentTime.getFullYear();
        const month = currentTime.getMonth() + 1;
        const day = currentTime.getDate();
        const hours = currentTime.getHours();
        const minutes = currentTime.getMinutes();
        const seconds = currentTime.getSeconds();

        const innerText = `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;

        document.querySelectorAll(".refresh_time").forEach(function (time) {
            time.innerText = innerText;
        });

    }

    const filter_inputList = document.querySelectorAll('.filter_input');

    filter_inputList.forEach(function (filter_input) {
        filter_input.addEventListener("keydown", function (event) {
            if (event.key === 'Enter') {
                if (this.offsetParent !== null) {
                    updateRefreshTime();
                }
            }
        });
    });

    const filter_submitList = document.querySelectorAll('.filter_submit');

    filter_submitList.forEach(function (filter_submit){
       filter_submit.addEventListener("click",updateRefreshTime);
    });

    document.querySelectorAll('.filter_refresh').forEach(function (refresh) {
       refresh.addEventListener("click",updateRefreshTime);
    });

    const navbarBtn = document.getElementById('QueryNavbarBtn');
    navbarBtn && navbarBtn.addEventListener("click",updateRefreshTime);

    const second_order_student_manager = document.getElementById('second_order_student_manager');
    second_order_student_manager && second_order_student_manager.addEventListener("click",updateRefreshTime);

    const second_order_venture_manager = document.getElementById('second_order_ventures_manager');
    second_order_venture_manager && second_order_venture_manager.addEventListener("click",updateRefreshTime);


});
