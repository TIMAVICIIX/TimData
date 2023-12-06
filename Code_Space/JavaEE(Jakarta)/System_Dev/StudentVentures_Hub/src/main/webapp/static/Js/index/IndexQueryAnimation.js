document.addEventListener('DOMContentLoaded', function () {
    function updateRefreshTime() {
        const currentTime = new Date();

        const year = currentTime.getFullYear();
        const month = currentTime.getMonth() + 1;
        const day = currentTime.getDate();
        const hours = currentTime.getHours();
        const minutes = currentTime.getMinutes();
        const seconds = currentTime.getSeconds();

        document.getElementById('refresh_time').innerText = `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;
    }

    document.getElementById('filter_submit').addEventListener('click',updateRefreshTime);
    document.getElementById('filter_refresh').addEventListener('click',updateRefreshTime);
    document.getElementById('QueryNavbarBtn').addEventListener('click',updateRefreshTime);
})
