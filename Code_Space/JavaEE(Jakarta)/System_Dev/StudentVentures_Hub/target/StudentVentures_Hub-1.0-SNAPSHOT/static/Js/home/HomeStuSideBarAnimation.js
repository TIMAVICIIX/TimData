const personal_first_order = document.getElementById("first_order_home_center");
const form_first_order = document.getElementById("first_order_form_manager");
const other_first_order = document.getElementById("first_order_other_manager");

const form_second_order_add = document.getElementById("second_order_form_add");
const form_second_order_history = document.getElementById("second_order_history_form");

const other_second_order_message = document.getElementById("second_order_message");
const other_second_order_transform = document.getElementById("second_order_transform");


const subMenu1 = document.getElementById("sub_order1");
const subMenu2 = document.getElementById("sub_order2");

const subMenuState = new Array(2).fill(true);
// const subItemState = new Array(5).fill(true);

let orderAreaID = ""

const fillArea = document.getElementById("navigation-tip");

const personalPage = document.getElementById("home_personal_center");
const form_addPage = document.getElementById("home_add_form");
const form_historyPage = document.getElementById("home_history_form");
const other_messagePage = document.getElementById("home_other_message");
const other_transformPage = document.getElementById("home_other_transform");

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

    form_first_order.style.backgroundColor = '#FFFFFF';
    form_first_order.style.borderTop = 'none';
    form_first_order.style.borderBottom = 'none';

    other_first_order.style.backgroundColor = '#FFFFFF';
    other_first_order.style.borderTop = 'none';
    other_first_order.style.borderBottom = 'none';

    subMenu1.style.height = "0";
    subMenu2.style.height = "0";

    subMenuState.fill(true);
    orderAreaID = personal_first_order.id;

    form_second_order_add.style.backgroundColor = '#FFFFFF';
    form_second_order_history.style.backgroundColor = '#FFFFFF';

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

    form_first_order.style.backgroundColor = '#FFFFFF';
    form_first_order.style.borderTop = 'none';
    form_first_order.style.borderBottom = 'none';

    other_first_order.style.backgroundColor = '#FFFFFF';
    other_first_order.style.borderTop = 'none';
    other_first_order.style.borderBottom = 'none';


    firstOrder.style.backgroundColor = '#EAEAEA';
    firstOrder.style.borderTop = '#919191 solid 1px';
    firstOrder.style.borderBottom = '#919191 solid 1px';


}

function setSubMenu(stateIndex) {

    subMenu1.style.height = "0";
    subMenu2.style.height = "0";

    if (stateIndex === 0) {
        subMenu1.style.height = subMenu1.scrollHeight + "px";
    } else if (stateIndex === 1) {
        subMenu2.style.height = subMenu2.scrollHeight + "px";
    }

}

function setSecondOrder(secondOrder) {
    form_second_order_add.style.backgroundColor = '#FFFFFF';
    form_second_order_history.style.backgroundColor = '#FFFFFF';

    other_second_order_message.style.backgroundColor = '#FFFFFF';
    other_second_order_transform.style.backgroundColor = '#FFFFFF';

    secondOrder.style.backgroundColor = '#c7c7c7';
}

function setText(fillText) {
    fillArea.innerText = fillText;
}

function changePage(changeTarget) {

    personalPage.style.display = 'none';
    form_addPage.style.display = 'none';
    form_historyPage.style.display = 'none';
    other_messagePage.style.display = 'none';
    other_transformPage.style.display = 'none';

    changeTarget.style.display = 'block';

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

personal_first_order.addEventListener('click', () => firstClick("个人中心", personalPage));

form_second_order_history.addEventListener('click', () => secondClick(form_first_order, form_second_order_history, 0, " 表单管理 > 历史填写表单", form_historyPage));
form_second_order_add.addEventListener('click', () => secondClick(form_first_order, form_second_order_add, 0, " 表单管理 > 填写假期表单", form_addPage));

other_second_order_message.addEventListener('click',()=>secondClick(other_first_order,other_second_order_message,1,"其他 > 校内讯息",other_messagePage));
other_second_order_transform.addEventListener('click',()=>secondClick(other_first_order,other_second_order_transform,1,"其他 > 转学",other_transformPage));
replace_icon.addEventListener('click', () => {
    personal_first_order.click();
});

personal_first_order.click();