const personal_first_order = document.getElementById("first_order_home_center");
const student_first_order = document.getElementById("first_order_student_manager");
const venture_first_order = document.getElementById("first_order_ventures_manager");
const collect_first_order = document.getElementById("first_order_collect_manager");

const student_second_order_add = document.getElementById("second_order_student_add");
const student_second_order_manage = document.getElementById("second_order_student_manager");
const student_second_order_audit = document.getElementById("second_order_student_audit");

const venture_second_order_add = document.getElementById("second_order_ventures_add");
const venture_second_order_manage = document.getElementById("second_order_ventures_manager");

const collect_second_order_manage = document.getElementById("second_order_collect_manager");
const collect_second_order_remind = document.getElementById("second_order_collect_remind");

const subMenu1 = document.getElementById("sub_order1");
const subMenu2 = document.getElementById("sub_order2");
const subMenu3 = document.getElementById("sub_order3");

const subMenuState = new Array(3).fill(true);
// const subItemState = new Array(5).fill(true);

let orderAreaID = ""

const fillArea = document.getElementById("navigation-tip");

const personalPage = document.getElementById("home_personal_center");
const student_addPage = document.getElementById("home_studentManage_add");
const student_managePage = document.getElementById("home_studentManage_manage");
const student_auditPage = document.getElementById("home_studentManage_audit");
const venture_addPage = document.getElementById("home_ventureManage_add");
const venture_managePage = document.getElementById("home_ventureManage_manage");
const collect_managePage = document.getElementById("home_ventureDispatch_manage");
const collect_remindPage = document.getElementById("home_ventureDispatch_remind");

const replace_icon = document.getElementById("icon_change_Btn");

function secondClick(fatherOrder, clickOrder, index, fillText, changeTarget) {


    if (orderAreaID !== fatherOrder.id.toString()) {
        orderAreaID = fatherOrder.id;
        subMenuState.fill(true);
        subMenuState[index] = subMenuState[index] !== true;
    }

    setFirstOrder(fatherOrder);
    setSubMenu(index);
    setSecondOrder(clickOrder);
    setText(fillText);

    changePage(changeTarget);


}

function firstClick(fillText, changeTarget) {

    student_first_order.style.backgroundColor = '#FFFFFF';
    student_first_order.style.borderTop = 'none';
    student_first_order.style.borderBottom = 'none';

    venture_first_order.style.backgroundColor = '#FFFFFF';
    venture_first_order.style.borderTop = 'none';
    venture_first_order.style.borderBottom = 'none';

    collect_first_order.style.backgroundColor = '#FFFFFF';
    collect_first_order.style.borderTop = 'none';
    collect_first_order.style.borderBottom = 'none';

    subMenu1.style.height = "0";
    subMenu2.style.height = "0";
    subMenu3.style.height = "0";

    subMenuState.fill(true);
    orderAreaID = personal_first_order.id;

    student_second_order_add.style.backgroundColor = '#FFFFFF';
    student_second_order_manage.style.backgroundColor = '#FFFFFF';

    venture_second_order_add.style.backgroundColor = '#FFFFFF';
    venture_second_order_manage.style.backgroundColor = '#FFFFFF';

    collect_second_order_manage.style.backgroundColor = '#FFFFFF';
    collect_second_order_remind.style.backgroundColor = '#FFFFFF';

    personal_first_order.style.backgroundColor = '#EAEAEA';
    personal_first_order.style.borderTop = '#919191 solid 1px';
    personal_first_order.style.borderBottom = '#919191 solid 1px';


    setText(fillText);
    changePage(changeTarget);
}

function setFirstOrder(firstOrder) {

    personal_first_order.style.backgroundColor = '#FFFFFF';
    personal_first_order.style.borderTop = 'none';
    personal_first_order.style.borderBottom = 'none';

    student_first_order.style.backgroundColor = '#FFFFFF';
    student_first_order.style.borderTop = 'none';
    student_first_order.style.borderBottom = 'none';

    venture_first_order.style.backgroundColor = '#FFFFFF';
    venture_first_order.style.borderTop = 'none';
    venture_first_order.style.borderBottom = 'none';

    collect_first_order.style.backgroundColor = '#FFFFFF';
    collect_first_order.style.borderTop = 'none';
    collect_first_order.style.borderBottom = 'none';


    firstOrder.style.backgroundColor = '#EAEAEA';
    firstOrder.style.borderTop = '#919191 solid 1px';
    firstOrder.style.borderBottom = '#919191 solid 1px';


}

function setSubMenu(stateIndex) {

    subMenu1.style.height = "0";
    subMenu2.style.height = "0";
    subMenu3.style.height = "0";

    if (stateIndex === 0) {
        subMenu1.style.height = subMenu1.scrollHeight + "px";
    } else if (stateIndex === 1) {
        subMenu2.style.height = subMenu2.scrollHeight + "px";
    } else if (stateIndex === 2) {
        subMenu3.style.height = subMenu3.scrollHeight + "px";
    }

}

function setSecondOrder(secondOrder) {
    student_second_order_add.style.backgroundColor = '#FFFFFF';
    student_second_order_manage.style.backgroundColor = '#FFFFFF';
    student_second_order_audit.style.backgroundColor = "#FFFFFF";

    venture_second_order_add.style.backgroundColor = '#FFFFFF';
    venture_second_order_manage.style.backgroundColor = '#FFFFFF';

    collect_second_order_manage.style.backgroundColor = '#FFFFFF';
    collect_second_order_remind.style.backgroundColor = '#FFFFFF';

    secondOrder.style.backgroundColor = '#c7c7c7';
}

function setText(fillText) {
    fillArea.innerText = fillText;
}

function changePage(changeTarget) {

    personalPage.style.display = 'none';
    student_addPage.style.display = 'none';
    student_managePage.style.display = 'none';
    student_auditPage.style.display = 'none';
    venture_addPage.style.display = 'none';
    venture_managePage.style.display = 'none';
    collect_remindPage.style.display = 'none';
    collect_managePage.style.display = 'none';

    document.getElementById(changeTarget).style.display = 'block';

}

function expandSubMenu(submenuId, index) {
    const submenu = document.getElementById(submenuId);
    if (submenu && subMenuState[index - 1] === true) {
        submenu.style.height = submenu.scrollHeight + "px";
    }
}

function collapseSubMenu(submenuId, index) {
    const submenu = document.getElementById(submenuId);
    if (submenu && subMenuState[index - 1] === true) {
        submenu.style.height = "0";
    }
}

personal_first_order.addEventListener('click', () => firstClick("个人中心", "home_personal_center"));

student_second_order_manage.addEventListener('click', () => secondClick(student_first_order, student_second_order_manage, 0, " 学生管理 > 学生一览", "home_studentManage_manage"));
student_second_order_add.addEventListener('click', () => secondClick(student_first_order, student_second_order_add, 0, " 学生管理 > 学生,专业,学院", "home_studentManage_add"));
student_second_order_add.addEventListener('click', function () {
    document.getElementById('addMessageStudentBtn').click();
});
student_second_order_audit.addEventListener('click', () => secondClick(student_first_order, student_second_order_audit, 0, "学生管理 > 学生审核", "home_studentManage_audit"));

venture_second_order_manage.addEventListener('click', () => secondClick(venture_first_order, venture_second_order_manage, 1, "假期管理 > 假期一览", "home_ventureManage_manage"));
venture_second_order_add.addEventListener('click', () => secondClick(venture_first_order, venture_second_order_add, 1, "假期管理 > 假期添加", "home_ventureManage_add"));

collect_second_order_manage.addEventListener('click', () => secondClick(collect_first_order, collect_second_order_manage, 2, "收发管理 > 收发一览", "home_ventureDispatch_manage"));
collect_second_order_remind.addEventListener('click', () => secondClick(collect_first_order, collect_second_order_remind, 2, "收发管理 > 收发提醒", "home_ventureDispatch_remind"));

replace_icon.addEventListener('click', () => {
    personal_first_order.click();
});

personal_first_order.click();