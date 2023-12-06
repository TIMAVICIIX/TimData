$(document).ready(function () {

    const loginBtn = $('#LoginBtn');
    const login_tips = $('#login_tips');

    function loginProcess() {

        const login_account = $('#login_account').val();
        const login_password = $('#login_password').val();

        if (login_account === ""){
            shakeTips("请输入账号");
        }else if(login_password === ""){
            shakeTips("请输入密码");
        }else {
            hiddenTips();

            $.ajax({

                dataType: 'text',
                type: 'POST',
                url: '/StudentVentures_Hub/index-controller',
                data:{action:'login_test',login_account:login_account,login_password:login_password},
                success:function (response) {
                    if (response === '404'){
                        shakeTips("用户不存在!")
                    }else if(response === '401'){
                        shakeTips("密码错误!")
                    }else if (response === '100'){
                        $('#loginForm').submit()
                    }
                },error:function (){
                    alert('网络错误!')
                }

            })
        }

    }

    function shakeTips(tips_String) {
        // alert('shake');

        login_tips.text(tips_String);

        login_tips.css('visibility','visible');
        login_tips.addClass('shake');

        login_tips.on('animationend',function (){
            login_tips.removeClass('shake');
        })
    }

    function hiddenTips(){
        login_tips.css('visibility','hidden');
    }

    loginBtn.click(loginProcess);

    document.addEventListener('keydown', function (event) {

        if (event.key === 'Enter') {
            loginBtn.click();
        }

    });

});